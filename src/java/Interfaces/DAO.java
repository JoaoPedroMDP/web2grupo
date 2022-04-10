package Interfaces;

import java.util.List;

import Exceptions.DAOException;
import Exceptions.NotFound;

public interface DAO<T> {
    T get(int id) throws DAOException, NotFound;
    List<T> getAll() throws DAOException;
    void insert(T t) throws DAOException;
    void update(T t) throws DAOException;
    void delete(T t) throws DAOException;

    void closeConnection();
}
