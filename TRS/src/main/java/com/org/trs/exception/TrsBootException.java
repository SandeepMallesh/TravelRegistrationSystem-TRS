package com.org.trs.exception;

/*All other user defined exception classes will inherit this exception class.*/

public class TrsBootException extends Exception{
    private  static final long serialVersionUID = 1L;

    /*Constructor*/
    public TrsBootException(String message) {
        super(message);
    }
}
