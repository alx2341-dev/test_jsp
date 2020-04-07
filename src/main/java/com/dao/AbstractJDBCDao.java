package com.dao;

import com.dto.DTO;
import com.adapters.OracleJDBC;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Абстрактный класс предоставляющий базовую реализацию операций с использованием JDBC.
 *
 * @param <T>  тип объекта
 */
public abstract class AbstractJDBCDao<T extends DTO> implements GenericDao<T> {

    /**
     * Возвращает sql запрос для получения всех записей.
     * <p/>
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    protected abstract List<T> parseResultSet(ResultSet rs) throws Exception;

    @Override
    public List<T> getAll() throws SQLException, NamingException {
        List<T> list = null;
        String sql = getSelectQuery();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = OracleJDBC.getContext();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            OracleJDBC.closeContext(connection,statement,rs);
        }
        return list;
    }

    public AbstractJDBCDao() {
    }
}
