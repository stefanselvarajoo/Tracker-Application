package a.elderwatch;


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
public class ReminderFragment extends Fragment {


    public ReminderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reminder, container, false);
        ImageButton add = (ImageButton)view.findViewById(R.id.ibAddReminder);
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
        AddReminderDialog myDialog = new AddReminderDialog();
        myDialog.show(manager,"MyDialog");
    }

}
