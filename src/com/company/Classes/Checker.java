package com.company.Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

public class Checker {
    private boolean create, newAccount;
    private int amountOfAccounts;
    private Account account;
    private String output;
    public Checker(boolean c, Account a){
        create = c;
        newAccount = false;
        amountOfAccounts = 0;
        account = a;
        output = "";
        checkUsernameAndPassword();
    }

    public Checker(Account a){
        create = false;
        account = a;
    }

    public boolean getNewAccount() { return newAccount; }

    public Account getAccount(){ return account; }

    public String getOutput() { return output; }

    public int getAmountOfAccounts() { return amountOfAccounts; }

    public void checkUsernameAndPassword(){
        try(BufferedReader bR = new BufferedReader(new FileReader("F://Login System//Account Information.txt"));
        BufferedReader bR2 = new BufferedReader(new FileReader("F://Login System//New Account.txt"))){
            Scanner amo = new Scanner(bR.readLine());
            amountOfAccounts = amo.nextInt()+1;
            int amount = amountOfAccounts-1;
            int index = 0; // maybe ask for a name to use HashMap, and later HashTable
            String[] usernames = new String[amountOfAccounts];
            String[] emails = new String[amountOfAccounts];
            String[] passwords = new String[amountOfAccounts];
            String[][] accountInfo = {usernames, emails, passwords};
            String[] newAccountInfo = {bR2.readLine(), bR2.readLine(), bR2.readLine()};
            for(int i = 0; i < newAccountInfo.length; i++)
                accountInfo[i][index] = newAccountInfo[i];
            while(index < amount){
                String[] information = {bR.readLine(), bR.readLine(), bR.readLine()};
                for(int i = 1; i < information.length; i++){
                    accountInfo[i][index] = information[i];
                    output += information[i]+"\n"; // WARNING: There's going to be an extra line in the file
                }
                bR.readLine(); // that's the extra line
                index++;
            }
            if(!create || account.getMoveOn()[4] == true){
                Login login = new Login();
                login.setUsernames(usernames);
                login.setEmails(emails);
                login.collectUsername();
                if(login.getNewAccount()){
                    Account account = new Account();
                    account.createAnAccount();
                    newAccount = true;
                    new Checker(account);
                }
                else {
                    login.setPasswords(passwords);
                    login.collectPassword();
                }
            }
        }
        catch(IOException e) {out.println(e.getMessage());}
    }
}
