package com.lizz.fundation.pattern;

import com.lizz.fundation.dto.UserDTO;

/**
 *
 * @author lizz365
 */
public enum Singleton {
    INSTANCE;
    private UserDTO userDTO;
    private Singleton(){
        userDTO = new UserDTO();
        userDTO.setId(365);
        userDTO.setName("lizz");
    }
    public UserDTO getUserDTO(){
        return userDTO;
    }

}
