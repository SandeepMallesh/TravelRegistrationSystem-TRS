package com.org.trs.exception;

/*This Exception is thrown from RegistrationService class with error message RegistrationService.INVALID_PASSWORD
 if the given email is not matching the constraints given in the regular expression.*/
public class InvalidPasswordException extends TrsBootException{
    private  static final long serialVersionUID = 1L;

    public InvalidPasswordException(String message) {
        super(message);
    }
}
