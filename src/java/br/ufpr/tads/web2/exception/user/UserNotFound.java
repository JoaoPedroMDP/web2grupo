package br.ufpr.tads.web2.exception.user;

import br.ufpr.tads.web2.exception.NotFound;

public class UserNotFound extends NotFound{
    public UserNotFound(){
        super("Usuário não encontrado");
    }

    public UserNotFound(Throwable t){
        super("Usuário não encontrado", t);
    }
}
