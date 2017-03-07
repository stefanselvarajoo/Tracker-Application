package com.nighthawk.trackerapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlertBookDetailsFragment extends Fragment {


    public AlertBookDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_alert_book_details, container, false);
        ImageButton add = (ImageButton)view.findViewById(R.id.ibAdd);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addMember(view);
            }
        });
        return view;
    }
    public void addMember(View view){
        FragmentManager manager = getFragmentManager();
        AddMemberDialog myDialog = new AddMemberDialog();
        myDialog.show(manager,"MyDialog");
    }

}
