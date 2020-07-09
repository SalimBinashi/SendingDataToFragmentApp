package com.example.sendingdatatofragmentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment implements View.OnClickListener {
    EditText editTName, editTMessage;
    Button btnSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        editTName = view.findViewById(R.id.editTName);
        editTMessage = view.findViewById(R.id.editTMessage);
        btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnSend)){
            if (validate()){
                //
                Bundle bundle = new Bundle();
                // set keys to the argument strings
                bundle.putString("name", editTName.getText().toString());
                bundle.putString("message", editTMessage.getText().toString());

                SecondFragment secondFragment = new SecondFragment();
                // sending data to second fragment
                secondFragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, secondFragment);
                fragmentTransaction.commit();
            }
        }

    }

    private boolean validate() {
        if (TextUtils.isEmpty(editTName.getText().toString())){
            Toast.makeText(getActivity(), "Name is missing", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(editTName.getText().toString())){
            Toast.makeText(getActivity(), "Please Enter message", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return  true;
    }
}