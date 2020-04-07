package com.dao;

import com.dto.DTO;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

/**
 * @param <T> тип объекта
 */
public interface GenericDao<T extends DTO> {

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll() throws SQLException, NamingException;
}
