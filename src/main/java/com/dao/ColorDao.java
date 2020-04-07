package com.dao;

import com.dto.Color;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ColorDao extends AbstractJDBCDao<Color> {

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM TSVETA";
    }

    @Override
    public String execProcOutput() {
        return "{call get_info(?,?)}";
    }

    public ColorDao() {
    }

    @Override
    protected List<Color> parseResultSet(ResultSet rs) throws Exception {
        LinkedList<Color> result = new LinkedList<Color>();
        try {
            while (rs.next()) {
                Color color = new Color();
                color.setId(rs.getInt("id"));
                color.setName(rs.getString("name"));
                color.setColorNumber(rs.getString("color_number"));
                result.add(color);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return result;
    }

    @Override
    protected String parseResultSetProc(ResultSet rs) throws Exception {
        String result = null;
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
}
