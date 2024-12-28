package com.test.common.gen.rule;

import lombok.Data;

import java.io.Serializable;

/**
 * Rule used to determine the Java Class name for an entity.
 */

@Data
public class ClassNameRule implements Serializable {
    private String tableName;
    private String className;
}
