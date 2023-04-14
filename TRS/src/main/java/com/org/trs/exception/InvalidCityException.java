package com.org.trs.exception;

/*If city doesn't match constraint given in regular expression during user registration
 this exception will be thrown from RegistraionService class*/
public class InvalidCityException extends TrsBootException{
    private  static final long serialVersionUID = 1L;


    public InvalidCityException(String message) {
        super(message);
    }
}
