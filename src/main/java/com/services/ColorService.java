package com.services;

import com.dao.DaoFactory;
import com.dao.GenericDao;
import com.dto.Color;
import com.dao.OracleDaoFactory;

import java.util.List;

public class ColorService implements Service<Color> {

    private DaoFactory oracleDaoFactory = null;

    public ColorService() {
        oracleDaoFactory = new OracleDaoFactory();
    }

    public List<Color> getDataList() throws Exception {
        GenericDao<Color> genericDao = oracleDaoFactory.getDao(Color.class);
        List<Color> colorList = genericDao.getAll();

        return colorList;
    }

    public String testProcOutput() throws Exception {
        GenericDao<Color> genericDao = oracleDaoFactory.getDao(Color.class);
        String testOutput = genericDao.getProcOutput("test");

        return testOutput;
    }

    /*public static void getData() {
        Connection conn = null;
        Statement stmt = null;  // Or PreparedStatement if needed
        ResultSet rs = null;
        try {
            conn = Repository.getConnection();
            System.out.println("opened connection");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from TSVETA");

            while (rs.next()) {
                System.out.println("query result =" + rs.getString(1));
            }

            System.out.println("Closed connection");

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always make sure result sets and statements are closed,
            // and the connection is returned to the pool
            ;
        }

    }*/
}
