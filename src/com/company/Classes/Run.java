package com.company.Classes;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;
public class Run {
    public static void main(String[] arqs){
        Scanner s = new Scanner(System.in);
        out.println("Welcome to Pointer!");
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
        String newAccount = "";
        if(create) {
            account.createAnAccount();
            newAccount = account.getUsername() + "\n" + account.getEmail() + "\n" + account.getPassword() + "\n";
            try (PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("F://Login System//New Account.txt")))) {
                fileOut.print(newAccount);
            } catch (IOException e) {out.println(e.getMessage());}
        }
        Checker checker = new Checker(create, account);
        if(checker.getNewAccount()) {
            Account altAccount = checker.getAccount();
            newAccount = altAccount.getUsername() + "\n" + altAccount.getEmail() + "\n" + altAccount.getPassword() + "\n";
        }
        try(PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("F://Login System//Account Information.txt")))){
            fileOut.println(checker.getAmountOfAccounts());
            fileOut.print(checker.getOutput()); // the old file output
            fileOut.print(newAccount);
        }
        catch(IOException e){out.println(e.getMessage());}
        out.println("You have now logged in!");
    }
}

