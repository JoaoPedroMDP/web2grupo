package br.ufpr.tads.web2.interfaces;

import java.util.List;

import br.ufpr.tads.web2.exception.DAOException;
import br.ufpr.tads.web2.exception.NotFound;

public interface DAO<T> {
    T get(int id) throws DAOException, NotFound;
    List<T> getAll() throws DAOException;
    void insert(T t) throws DAOException;
    void update(T t) throws DAOException;
    void delete(T t) throws DAOException;

    void closeConnection();
}
