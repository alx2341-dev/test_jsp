package com.dto;

import com.dto.DTO;

public class Color extends DTO {

    private String name;
    private String colorNumber;

    public Color(Integer id) {
        super(id);
    }

    public Color() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber = colorNumber;
    }
}
