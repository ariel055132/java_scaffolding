package com.test.common.gen.maven;

import com.test.common.gen.CodeGenerator;
import com.test.common.gen.config.CodeGeneratorConfig;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal generateAll
 * @phase process-sources
 */

public class EntityGenMojo extends AbstractMojo {
    /**
     * @parameter configPath
     */
    protected String configPath = "src/main/resources/entityGenConfig.yml";

    @Override
    public void execute() throws MojoExecutionException {
        try {
            CodeGeneratorConfig config = CodeGeneratorConfig.load(configPath);
            CodeGenerator.generateAll(config);
        } catch (Exception e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }
}
