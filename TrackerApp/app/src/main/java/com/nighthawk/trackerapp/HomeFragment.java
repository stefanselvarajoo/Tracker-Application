package com.nighthawk.trackerapp;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.nighthawk.trackerapp.Helper.HTTPRequest;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle  savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseMessaging.getInstance().subscribeToTopic("SOS");
        String token = FirebaseInstanceId.getInstance().getToken();
        ImageButton helpButton = (ImageButton) getView().findViewById(R.id.imageButton4);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HTTPRequest httpRequest = new HTTPRequest();
                httpRequest.execute("HELP!!!");

            }
        });
    }


}
