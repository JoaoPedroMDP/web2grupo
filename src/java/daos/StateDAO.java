package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.State;
import exceptions.DAOException;

public class StateDAO extends BaseDAO<State>{

    public StateDAO(Connection con) throws DAOException {
        if(con == null){
            throw new DAOException("Conexão nula ao criar StateDAO");
        }
        
        this.con = con;
        this.tableName = "tb_estado";
        this.subject = "nome_estado";
        this.columns = new ArrayList<String>(){{
            add("name");
        }};
    }

    @Override
    protected void configureStatement(PreparedStatement stmt, State state) throws SQLException {
        stmt.setString(1, state.getName());
    }

    @Override
    protected State fillFromResultSet(ResultSet rs)
     throws SQLException {
        State state = new State();
        Integer id = rs.getInt("id_estado");
        if(id != 0){
            state.setId(id);
        }

        state.setName(rs.getString("nome_estado"));

        return state;
    }
}
