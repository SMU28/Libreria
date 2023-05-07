package exercice.libreria;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import exercice.libreria.data.Persona;


public class PersonaRecyclerViewAdapter extends RecyclerView.Adapter<PersonaRecyclerViewAdapter.ViewHolder>{

    private Cursor cursorListaPersonas;
    private OnItemClickListener listenerClick;

    public PersonaRecyclerViewAdapter(OnItemClickListener listenerClick) {
        this.listenerClick = listenerClick;
    }

    interface OnItemClickListener{
        public void onClick(ViewHolder view, Persona personaActualizada);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.usuario_item_layout,parent,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cursorListaPersonas.moveToPosition(position);
        Persona personaSeleccionada = new Persona( cursorListaPersonas );
        holder.idPersonaLista.setText( Integer.toString(personaSeleccionada.getIdPersona()) );
        holder.namePersonaLista.setText( personaSeleccionada.getNamePersona() );
        holder.passwordPersonaLista.setText( personaSeleccionada.getPasswordPersona());
    }

    @Override
    public int getItemCount() {
        if (cursorListaPersonas!=null)
            return cursorListaPersonas.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor){
        if(nuevoCursor!=null){
            cursorListaPersonas = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView idPersonaLista;
        TextView namePersonaLista;
        TextView passwordPersonaLista;

        public ViewHolder(View itemView) {
            super( itemView );
            idPersonaLista = (TextView) itemView.findViewById( R.id.idPersonaLista );
            namePersonaLista = (TextView) itemView.findViewById( R.id.namePersonaLista );
            passwordPersonaLista = (TextView) itemView.findViewById( R.id.passwordPersonaLista );
            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick(View v) {
           Persona personaActualizada = obtenerUsuario( getAdapterPosition() );
            personaActualizada.setNamePersona("Pepe");
            listenerClick.onClick( this,personaActualizada );
        }
    }

    private Persona obtenerUsuario(int posicion){
        if (cursorListaPersonas!=null){
            cursorListaPersonas.moveToPosition( posicion );
            Persona nuevoUsuario = new Persona( cursorListaPersonas );
            return nuevoUsuario;
        }
        return null;
    }
}
