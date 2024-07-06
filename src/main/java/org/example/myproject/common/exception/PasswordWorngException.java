package org.example.myproject.common.exception;

public class PasswordWorngException extends Exception {
    public PasswordWorngException() {super();}
    public PasswordWorngException(String message) {super(message);}
    public PasswordWorngException(String message, Throwable cause) {super(message, cause);}
    public PasswordWorngException(Throwable cause) {super(cause);}
}
