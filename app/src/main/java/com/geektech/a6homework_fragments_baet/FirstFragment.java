package com.geektech.a6homework_fragments_baet;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

    private FragmentListeners fragmentListeners;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentListeners = (FragmentListeners) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_fragment, container, false);
        Button hideButton = view.findViewById(R.id.button_first);
        Button showButton = view.findViewById(R.id.button_second);


        hideButton.setOnClickListener(v ->
                fragmentListeners.onSecondFragmentListener());

        showButton.setOnClickListener(v ->
                fragmentListeners.onFirstFragmentListener());
        return view;


    }
}