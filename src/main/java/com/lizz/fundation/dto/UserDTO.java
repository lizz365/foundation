package com.lizz.fundation.dto;

import java.io.Serializable;

/**
 * share DTO
 * @author lizz365
 */
public class UserDTO implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
