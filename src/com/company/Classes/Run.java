package com.company.Classes;
import com.company.Classes.Account;
import com.company.Classes.Login;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
public class Run {
    public static void main(String[] arqs){
        // Login system: Username and password
        // create a create account window
        // give the user options to make an account or login
        // when creating an account, ask for a username, email, password, and retyping the password
        Scanner s = new Scanner(System.in);
        out.println("Welcome to *Website Name*!");
        Account account = new Account();
        String[] inputs = {"","","",""};
        boolean[] moveOn = {false,false,false,false,false};
        while(!moveOn[0]){
            out.print("Do you want to login or create an account (\"login\" or \"create an account\")? ");
            inputs[0] = s.nextLine();
            if(inputs[0].contains("login") || inputs[0].contains("create an account"))
                moveOn[0] = true;
            else
                out.println("Invalid Input! Try Again!");
        }
        boolean create = inputs[0].contains("create an account");
        if(create)
            account.createAnAccount();
        try(BufferedReader bR = new BufferedReader(new FileReader("F://Login System//Account Information.txt"))){
            Scanner amo = new Scanner(bR.readLine());
            int amount = amo.nextInt();
            int index = 0;
            String[] usernames = new String[amount]; // mayeb ask for a name to use HashMap, and later HashTable
            String[] emails = new String[amount];
            String[] passwords = new String[amount];
            while(index < amount){
                String[] information = {bR.readLine(), bR.readLine(), bR.readLine()}; // File Structure: Username, email, password
                usernames[index] = information[0];
                emails[index] = information[1];
                passwords[index] = information[2];
                index++;
            }
            if(!create || account.getMoveOn()[4] == true){
                Login login = new Login();
                login.collectUsername();
                if(login.getNewAccount()){}

                while(!moveOn[4]){
                    out.println("Password: ");
                    inputs[3] = s.nextLine();
                    // create a way to read from a list of passwords collected from a file
                    //                 else
                    //                     out.println("Incorrect Password! Try Again!");
                }
                // check to see if account exists through the username
            }
        }
        catch(IOException e) {out.println(e.getMessage());}
        try(PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("F://Login System//Account Information.txt")))){

        }
        catch(IOException e){out.println(e.getMessage());}
        out.println("You have now logged in!");
    }
}

