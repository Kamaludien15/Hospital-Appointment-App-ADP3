package za.ac.cput.util;

import java.util.UUID;

public class Helper {

    //-----Checking null or empty values-----
    public static boolean isNullEmpty(String s){
        return (s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    //-----Generating ID's for different entity's-----
    public static String generateID(){

        return UUID.randomUUID().toString();
    }

     /*public static boolean isValidEmail(String email){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }*/

}
