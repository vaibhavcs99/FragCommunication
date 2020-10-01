package com.example.fragcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentOne.FragmentAListener, FragmentTwo.FragmentBListner {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout1,fragmentOne)
                .replace(R.id.layout2,fragmentTwo)
                .commit();

    }


    @Override
    public void onInputASent(CharSequence input) {
        fragmentTwo.updateText(input);
    }

    @Override
    public void OnInputBSent(CharSequence input) {
        fragmentOne.updateText(input);
    }
}