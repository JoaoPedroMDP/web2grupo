package interfaces;

import java.util.List;

import exceptions.DAOException;
import exceptions.NotFound;

public interface DAO<T> {
    T get(Integer id) throws DAOException, NotFound;
    List<T> getAll() throws DAOException;
    void insert(T t) throws DAOException;
    void update(T t) throws DAOException;
    void delete(T t) throws DAOException;

    void closeConnection();
}
