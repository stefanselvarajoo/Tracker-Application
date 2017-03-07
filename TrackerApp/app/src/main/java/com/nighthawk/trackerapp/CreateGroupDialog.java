package com.nighthawk.trackerapp;

/**
 * Created by zxkirazx on 22/2/2017.
 */
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateGroupDialog extends DialogFragment {
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dialog_creategroup, container, false);
        return view;
    }
}
