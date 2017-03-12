package com.nighthawk.trackerapp.Model;

/**
 * Created by Michael on 11/3/17.
 */

public class SingletonStorage {
    private static SingletonStorage instance = new SingletonStorage();
    private String accountID = null;
    private String tokenID = null;

    private SingletonStorage(){
    }

    public static SingletonStorage getInstance(){
        return instance;
    }

    public void updateAccountID(String accountID){
        this.accountID = accountID;
    }

    public void updateTokenID(String tokenID){
        this.tokenID = tokenID;
    }

    public String getAccountID(){
        return this.accountID;
    }
    public String getTokenID(){
        return this.tokenID;
    }
}
