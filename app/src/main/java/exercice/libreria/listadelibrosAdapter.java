package exercice.libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class listadelibrosAdapter extends ArrayAdapter<listadelibros> {
    private Context mContext;
    private int  mResource;



    public listadelibrosAdapter(@NonNull Context context, int resource, @NonNull ArrayList<listadelibros> objects) {
        super(context, resource, objects);
        this.mContext =context;
        this.mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =  LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);
        ImageView imageView = convertView.findViewById(R.id.Libro1);

        TextView TextName = convertView.findViewById(R.id.NomLib1);

        imageView.setImageResource(getItem(position).getImage());
        TextName.setText(getItem(position).getName());

        return convertView;

    }
}
