package br.ufpr.tads.web2.interfaces;

import br.ufpr.tads.web2.exception.DAOException;
import br.ufpr.tads.web2.exception.NotFound;

public interface Tests {
    void testInsertion() throws DAOException;
    void testGet() throws DAOException, NotFound;
    void testIndex() throws DAOException ;
    void testDeletion() throws DAOException, NotFound ;
    void testUpdate() throws DAOException, NotFound ;
}
