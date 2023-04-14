package com.org.trs.exception;

/*This Exception is thrown from RegistrationService class with error message RegistrationService.INVALID_USER_ID
 if the given email is not matching the constraints given in the regular expression.*/
public class InvalidUserIdException extends TrsBootException {
    private  static final long serialVersionUID = 1L;

    public InvalidUserIdException(String message) {

        super(message);
    }
}
