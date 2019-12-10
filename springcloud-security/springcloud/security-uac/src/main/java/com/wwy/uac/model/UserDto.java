package com.wwy.uac.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author wwy
 */
@Data
@ToString
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
