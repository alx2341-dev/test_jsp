package com.dto;

/**
 * Объектное представление сущности цвета
 */

public abstract class DTO{

    private Integer id = null;

    public DTO(Integer id) {
        this.id = id;
    }

    public DTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) { this.id = id;  }
}
