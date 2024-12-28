package com.test.common.gen;

import com.test.common.gen.config.CodeGeneratorConfig;
import org.junit.jupiter.api.Test;

class CodeGeneratorTest {


    @Test
    void genTest() throws Exception {
        CodeGeneratorConfig config = CodeGeneratorConfig.load("entityGenConfig.yml");
        config.setPackageName("com.test.common.gen.entity");
        config.setOutputDirectory("src/test/java");
        CodeGenerator.generateAll(config, false);
    }
}
