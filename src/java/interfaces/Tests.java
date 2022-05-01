package interfaces;

import exceptions.DAOException;
import exceptions.NotFound;

public interface Tests {
    void testInsertion() throws DAOException;
    void testGet() throws DAOException, NotFound;
    void testIndex() throws DAOException ;
    void testDeletion() throws DAOException, NotFound ;
    void testUpdate() throws DAOException, NotFound ;
}
