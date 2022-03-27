package com.company.Classes;
import java.util.regex.*;
import java.util.Scanner;
import static java.lang.System.*;
public class Account
{
    private final String[] emailAddressEndings = {"outlook.com","gmail.com","yahoo.com","inbox.com","icloud.com","me.com","mac.com","mail.com","aol.com","zoho.com","yandex.com","live.com","hotmail.com","protonmail.com"}; // research how to add Google Apps for Business
    private final boolean[] start = {false,false,false,false,false};
    private final String[] start2 = {"","","","",""};
    private Scanner s;
    private boolean[] moveOn;
    private String[] inputs;
    private String username, email, password;
    public Account(){
        s = new Scanner(System.in);
        moveOn = start;
        inputs = start2;
        username = "";
        email = "";
        password = "";
    }

    public void setUsername(String u){
        username = u;
    }

    public void setEmail(String e){
        email = e;
    }

    public void setPassword(String p){
        password = p;
    }

    public boolean[] getMoveOn() {
        return moveOn;
    }

    public boolean checkUsername(String input){
        if(Pattern.matches("[a-zA-Z0-9]{13}.*", input))
            return true;
        return false;
    }

    public boolean checkEmail(String input){
        for(String emailAddressEnding: emailAddressEndings)
            if(input.contains(emailAddressEnding))
                return true;
        return false;
    }

    public boolean checkPassword(String input){
        if(Pattern.matches("[a-zA-Z0-9]{13}.*", input) && Pattern.matches(".*[A-Z].*", input) && Pattern.matches(".*[//W].*", input))
            return true;
        return false;
    }

    public void createAnAccount() {
        while(!moveOn[0]){
            out.print("Username (Must be at least 13 characters): ");
            inputs[0] = s.nextLine();
            if(checkUsername(inputs[0])){
                setUsername(inputs[0]);
                moveOn[0] = true;
            }
            else
                out.println("Invalid Username! Try Again!");
        }
        while(!moveOn[1]){
            out.print("Email: ");
            inputs[1] = s.nextLine();
            if(checkEmail(inputs[1])){
                setEmail(inputs[1]);
                moveOn[1] = true;
            }
            else
                out.println("Invalid Email Address! Try Again!");
        }
        while(!moveOn[2]){
            out.print("Password (Must be at least 13 characters with at least 1 Capital Letter and 1 Special Character): ");
            inputs[2] = s.nextLine();
            if(checkPassword(inputs[2])){
                setPassword(inputs[2]);
                moveOn[2] = true;
            }
            else
                out.println("Invalid Password! Try Again!");
        }
        while(!moveOn[3]){
            out.print("Retype Password: ");
            inputs[3] = s.nextLine();
            if(inputs[2].equals(inputs[3]))
                moveOn[3] = true;
            else
                out.println("Wrong Password! Try Again!");
        }
        out.println("You have now created an account!");
        while(!moveOn[4]){
            out.print("Do you want to login (yes or no)? ");
            inputs[4] = s.nextLine();
            if(inputs[4].contains("yes") || inputs[4].contains("no"))
                moveOn[4] = true;
            else
                out.println("Invalid Answer! Try Again!");
        }
    }
}


