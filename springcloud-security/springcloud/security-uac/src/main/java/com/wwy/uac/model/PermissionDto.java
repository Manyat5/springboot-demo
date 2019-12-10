package com.wwy.uac.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author wwy
 */
@Data
@ToString
public class PermissionDto {
    private String id;
    private String code;
    private String desciption;
    private String url;
}
