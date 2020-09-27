package com.example.mycounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            CounterButton counterButton = new CounterButton();
            CounterText counterText = new CounterText();

            FragmentManager mgr = getFragmentManager();
            FragmentTransaction fragTran = mgr.beginTransaction();

            fragTran.add(R.id.counterbutton, counterButton, "counterbutton");
            fragTran.add(R.id.countertext, counterText, "countertext");
            fragTran.commit();
        }
    }
    public void respond(String data) {
        FragmentManager mgr = getFragmentManager();
        CounterText counterText = (CounterText) mgr.findFragmentById(R.id.countertext);
        counterText.changeData(data);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}