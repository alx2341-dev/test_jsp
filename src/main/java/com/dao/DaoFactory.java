package com.dao;


import com.dto.DTO;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory<T extends DTO> {

    public interface DaoCreator<T extends DTO> {
        public GenericDao<T> create();
    }

    /** Возвращает объект DAO */
    public GenericDao<T> getDao(Class dtoClass) throws Exception;
}
