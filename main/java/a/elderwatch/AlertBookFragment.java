package a.elderwatch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlertBookFragment extends Fragment {
    public AlertBookFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_alertbook, container, false);
        TextView createGroup = (TextView) view.findViewById(R.id.tvCreateGroup);
        createGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                createGroup(view);
            }
        });
        return view;
    }
public void createGroup(View view){
    FragmentManager manager = getFragmentManager();
    CreateGroupDialog myDialog = new CreateGroupDialog();
    myDialog.show(manager,"MyDialog");
}

}
