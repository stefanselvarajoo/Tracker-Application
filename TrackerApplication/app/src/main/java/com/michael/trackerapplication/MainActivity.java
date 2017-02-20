package com.michael.trackerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView mConditionTextView;
    Button mButtonSunny;
    Button mButtonFoggy;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mconditionRef = mRootRef.child("condition");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI elements
        mConditionTextView = (TextView)findViewById(R.id.conditiontextView);
        mButtonSunny = (Button)findViewById(R.id.sunnybutton);
        mButtonFoggy = (Button)findViewById(R.id.foggybutton);
    }

    @Override
    protected void onStart(){
        super.onStart();

        mconditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                String text = dataSnapshot.getValue(String.class);
                mConditionTextView.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });

        mButtonSunny.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mconditionRef.setValue("Sunny");
            }
        });

        mButtonFoggy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mconditionRef.setValue("Foggy");
            }
        });
    }
}
