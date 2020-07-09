package com.example.sendingdatatofragmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {
    // initialize views
    TextView txtMessage;

    private Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        // init bundle arguments
        bundle = getArguments();

        // init the arguments
        String name = bundle.getString("name");
        String message = bundle.getString("message");

        // view binding
        txtMessage = view.findViewById(R.id.txtMessage);

        // set data
        txtMessage.setText("Name: "+name+ "\nMessage: "+message);
        return view;
    }
}