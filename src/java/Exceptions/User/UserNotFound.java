package Exceptions.User;

import Exceptions.NotFound;

public class UserNotFound extends NotFound{
    public UserNotFound(){
        super("Usuário não encontrado");
    }

    public UserNotFound(Throwable t){
        super("Usuário não encontrado", t);
    }
}
