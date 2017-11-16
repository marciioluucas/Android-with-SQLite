package org.marciolucas.contatinhos.controller;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.marciolucas.contatinhos.R;
import org.marciolucas.contatinhos.model.Contatinho;
import org.marciolucas.contatinhos.service.ContatinhoDAO;
import org.marciolucas.contatinhos.util.AdapterListaContatinhos;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaCurtidaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaCurtidaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ListaCurtidaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaCurtidaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaCurtidaFragment newInstance(String param1, String param2) {
        ListaCurtidaFragment fragment = new ListaCurtidaFragment();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_curtida, container, false);
        ArrayList<Contatinho> todosContatinhos = new ContatinhoDAO(getActivity().getApplicationContext()).retreaveByCurtida();
        ListView listView = (ListView) v.findViewById(R.id.listaContatinhosCurtidos);
        AdapterListaContatinhos adapter = new AdapterListaContatinhos(getContext(),todosContatinhos, getActivity());
        listView.setAdapter(adapter);
        return v;
    }

}
