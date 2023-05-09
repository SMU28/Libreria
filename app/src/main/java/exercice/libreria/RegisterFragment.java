package exercice.libreria;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import exercice.libreria.data.DAOLibreria;
import exercice.libreria.data.Persona;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText id;
    private EditText name;
    private EditText password;
    private DAOLibreria DAO;

    public void registrar(View v) {
            String idString = id.getText().toString();
            String nameString = name.getText().toString();
            String passwordString = password.getText().toString();

            if (idString.isEmpty() || nameString.isEmpty() || passwordString.isEmpty()) {
                Toast.makeText(getActivity(), "Faltan datos por completar", Toast.LENGTH_SHORT).show();
                return;
            }

            Persona personaguardar = new Persona(
                    Integer.parseInt(idString),
                    nameString,
                    passwordString);
            DAO.savePersona(personaguardar);

            Toast.makeText(getActivity(), "Registro exitoso", Toast.LENGTH_SHORT).show();


        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, new LoginFragment());
        transaction.commit();

    }




    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        id = view.findViewById(R.id.editTextID);
        name = view.findViewById(R.id.editTextTextPersonName2);
        password = view.findViewById(R.id.editTextPassword);
        Button btnRegistrar = view.findViewById(R.id.BotonR2);

        DAO = new DAOLibreria(getActivity().getApplicationContext());

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar(v);
                Toast.makeText(getActivity(), "Se ha registrado exitosamente", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}