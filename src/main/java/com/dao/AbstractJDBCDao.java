package com.dao;

import com.dto.DTO;
import com.adapters.OracleJDBC;

import javax.naming.NamingException;
import java.sql.*;
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
    protected abstract String getSelectQuery();

    protected abstract String execProcOutput();

    protected abstract List<T> parseResultSet(ResultSet rs) throws Exception;

    protected abstract String parseResultSetProc(ResultSet rs) throws Exception;

    @Override
    public String getProcOutput(String input) throws SQLException, NamingException {
        String sql = execProcOutput();
        String output = null;

        Connection connection = null;
        CallableStatement cstmt = null;

        try {
            connection = OracleJDBC.getContext();
            cstmt = connection.prepareCall(sql);
            cstmt.setString(1, input);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.executeQuery();
            output = cstmt.getString(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            OracleJDBC.closeContext(connection,cstmt,null);
        }
        return output;
    }

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
