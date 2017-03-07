package com.nighthawk.trackerapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
    }

    @Override
    public void onStart(){
        super.onStart();
        final Intent registerIntent = new Intent(this,RegisterFragment.class);
        Button login = (Button)findViewById(R.id.btLogin);
        final Button register = (Button)findViewById(R.id.etRegister);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(registerIntent);
            }
        });
    }


//    public LoginFragment() {
//        // Required empty public constructor
//        mFirebaseAuth = FirebaseAuth.getInstance();
//    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false);
//
//    }

//    public void signIn(String email, String password){
//        final TextView message = (TextView)findViewById(R.id.errorMessage);
//        final Intent mainPageIntent = new Intent(this, MainPage.class);
//        if(email.equals("")||password.equals("")){
//            message.setText("Email or Password cannot be empty!");
//            CharSequence success = "Email or Password cannot be empty!";
//            Context context = getApplicationContext();
//            Toast toast = Toast.makeText(context, success, Toast.LENGTH_SHORT);
//            toast.show();
//
//        }
//        else{
//
//            mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()) {
//                        CharSequence success = "Suceess Verification";
//                        Context context = getApplicationContext();
//                        Toast toast = Toast.makeText(context, success, Toast.LENGTH_SHORT);
//                        toast.show();
//                        startActivity(mainPageIntent);
//                    }
//                    else{
//                        CharSequence error = "Unsuccessful Log In!";
//                        Context context = getApplicationContext();
//                        Toast toast = Toast.makeText(context,error, Toast.LENGTH_SHORT);
//                        toast.show();
//                        message.setText("Please check your email or password!");
//                    }
//                }
//            });
//
//        }
//    }

}
