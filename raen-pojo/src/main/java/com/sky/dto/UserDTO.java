package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String username;

    private String password;

    private String name;

    private Long articles;

    private String avatar;

    private Long practices;

    private String sex;

    private String phoneNumber;

}
