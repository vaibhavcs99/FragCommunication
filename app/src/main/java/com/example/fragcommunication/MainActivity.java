package com.example.fragcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager = getSupportFragmentManager();





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentOne fragmentOne = new FragmentOne();
        FragmentTwo fragmentTwo = new FragmentTwo();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.layout1,fragmentOne,"A").addToBackStack(null);
        transaction.add(R.id.layout2,fragmentTwo,"B").addToBackStack(null).commit();

    }


    public void sendData(View view){
        EditText et1 = findViewById(R.id.PersonName1);
        Bundle bundle = new Bundle();

        bundle.putString("name1",et1.getText().toString());

        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTwo.setArguments(bundle);
    }
}