package tn.esprit.operationservice.exceptions;

public class InvalidHashPasswordException extends Exception{

    public InvalidHashPasswordException(String str){
        super(str);
    }

}
