package com.geektech.a6homework_fragments_baet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FragmentListeners {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.third_fragmentMain, ThirdFragment.newInstance("",""));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void onFirstFragmentListener() {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.second_fragment);
        // скрывает hide();
        assert fragment != null;
        fragmentTransaction.hide(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onSecondFragmentListener() {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.second_fragment);
        //показывает  show();
        assert fragment != null;
        fragmentTransaction.show(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onSendMessage(String text) {
        fragmentTransaction=fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.second_fragment);
        assert fragment != null;
        ((TextView) Objects.requireNonNull(fragment.getView()).findViewById(R.id.txt_view_second_fragment)).setText(text);
        fragmentTransaction.show(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}