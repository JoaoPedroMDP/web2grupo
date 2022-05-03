package br.ufpr.tads.web2.exception;

public class NotFound extends Exception{
    public NotFound(String message){
        super(message);
    }

    public NotFound(String message, Throwable t){
        super(message, t);
    }
}
