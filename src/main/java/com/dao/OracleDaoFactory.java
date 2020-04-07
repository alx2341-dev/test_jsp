package com.dao;

import com.dao.ColorDao;
import com.dao.DaoFactory;
import com.dao.GenericDao;
import com.dto.Color;
import com.dto.DTO;

import java.util.HashMap;
import java.util.Map;

public class OracleDaoFactory implements DaoFactory<DTO> {

    private Map<Class, DaoCreator<?>> creators;

    @Override
    public GenericDao getDao(Class dtoClass) throws Exception {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new Exception("custom exception: Dao object for " + dtoClass + " not found.");
        }
        return creator.create();
    }

    public OracleDaoFactory() {
        creators = new HashMap<>();
        creators.put(Color.class, new DaoCreator<Color>() {
            @Override
            public GenericDao<Color> create() {
                return new ColorDao();
            }
        });
    }

}
