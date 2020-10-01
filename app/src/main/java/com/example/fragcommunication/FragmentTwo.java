package com.example.fragcommunication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentTwo extends Fragment {
    FragmentBListner listner;
    private EditText editText;
    public Button button;

    public interface FragmentBListner{
        void OnInputBSent(CharSequence input);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        editText = view.findViewById(R.id.PersonName2);
        button = view.findViewById(R.id.send2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listner.OnInputBSent(input);
            }
        });
        return view;
    }

    public void updateText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListner){
            listner = (FragmentBListner) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }
}