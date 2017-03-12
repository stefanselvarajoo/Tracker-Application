package com.nighthawk.trackerapp.Helper;

import android.content.Context;
import android.util.Log;

import com.nighthawk.trackerapp.Model.LoginModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Michael on 11/3/17.
 */

public class LoginInfo {
    private static LoginModel loginModel = LoginModel.getInstance();
//    private static String path = com/nighthawk/trackerapp/Helper/login_info;
    public static boolean isEmptyFile() {
        File file = new File("login_info.txt");
        if(file.length()!=0){
            return false;
        }
        else{
            return true;
        }
    }

//    public static LoginModel read() throws IOException{
//        Scanner scanner = new Scanner("login_info.txt");
//        if(!LoginInfo.isEmptyFile()){
//            String id = scanner.nextLine();
//            String password = scanner.nextLine();
//            loginModel.setId(id);
//            loginModel.setPassword(password);
//            System.out.println(id);
//        }
//        return loginModel;
//    }
//
//    public static void save(String id, String pass) throws IOException{
//        PrintWriter writer = new PrintWriter("login_info.txt");
//        writer.println(id);
//        writer.println(pass);
//    }
//
//    public static void clear() throws IOException{
//        PrintWriter writer = new PrintWriter("login_info.txt");
//    }

    public static void writeToFile(String id, String pass,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("login_info.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(id);
            outputStreamWriter.append("\n\r");
            outputStreamWriter.append(pass);

            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static LoginModel readFromFile(Context context) {

        List<String> login = new ArrayList<>();

        try {
            InputStream inputStream = context.openFileInput("login_info.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    login.add(receiveString);
                }

                inputStream.close();
                if(login.size() > 0){
                    loginModel.setId(login.get(0));
                    loginModel.setPassword(login.get(1));
                }
                else {
                    loginModel.setId(null);
                    loginModel.setPassword(null);
                }
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return loginModel;
    }

}
