package com.geektech.a6homework_fragments_baet;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ThirdFragment extends Fragment {

    private EditText editText;
    private FragmentListeners listeners;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listeners=(FragmentListeners)context;
    }

    public ThirdFragment() {
        // Required empty public constructor
    }

    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.third_layout, container, false);
        Button buttonSend = view.findViewById(R.id.btnSend);
        editText=view.findViewById(R.id.etText);

        buttonSend.setOnClickListener(v ->
                listeners.onSendMessage(editText.getText().toString()));
        return view;
    }
}