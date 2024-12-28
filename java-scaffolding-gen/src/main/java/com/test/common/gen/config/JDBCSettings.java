package com.test.common.gen.config;

import lombok.Data;

import java.io.Serializable;

/**
 * JDBC Connection Settings
 */

@Data
public class JDBCSettings implements Serializable {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String schemaPattern;
}
