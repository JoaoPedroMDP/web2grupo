package br.ufpr.tads.web2.exception;

public class DAOException extends Exception{
    public DAOException(){}

    public DAOException(String string){
        super(string);
    }

    public DAOException(String string, Throwable t){
        super(string, t);
    }
}

