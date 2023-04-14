package com.org.trs.exception;

/*This Exception is thrown from RegistrationService class with error message RegistrationService.INVALID_PHONE_NUMBER
 if the given email is not matching the constraints given in the regular expression.*/
public class InvalidPhoneException extends TrsBootException{
    private  static final long serialVersionUID = 1L;

    public InvalidPhoneException(String message) {
        super(message);
    }
}
