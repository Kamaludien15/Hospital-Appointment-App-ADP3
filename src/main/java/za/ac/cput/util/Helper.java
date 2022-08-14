package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class Helper {

    //-----Generating ID's for different entity's-----
    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    //-----Check to see if a string is empty or null-----
    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    //-----Sets string to empty if null-----
    public static String setEmptyIfNull(String str){
        if(isEmptyOrNull(str))return "";
        return str;
    }

    //-----Check to see if a string is empty or null with param name-----
    public static void checkingStringParam(String paramName, String paramValue){
        if(isEmptyOrNull(paramValue)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }

    //-----Check to see if a int is empty or null or within a range of 1000 - 9999 with param name-----
    public static void checkingIntParam(String paramName, int paramValue){
        if(paramValue == 0 || !(paramValue >= 1000 && paramValue <= 9999)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }


    //-----Check to see if an entity is null with param name-----
    public static void checkingEntityParam(String paramName, Object paramValue){
        if(paramValue.equals(null)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }

    //-----Check to see if an entity is null-----
    public static boolean checkingEntity(Object paramValue){
        if(paramValue.equals(null)){
            return true;
        } else {
            return false;
        }
    }

    //-----Check to see if a email is valid-----
    public static void checkingEmailParam(String paramName, String paramValue){
        if(!EmailValidator.getInstance().isValid(paramValue)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }

}
