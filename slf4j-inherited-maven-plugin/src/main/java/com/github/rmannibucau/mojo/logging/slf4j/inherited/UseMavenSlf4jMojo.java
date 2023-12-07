package com.github.rmannibucau.mojo.logging.slf4j.inherited;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.slf4j.LoggerFactory;

@Mojo(name = "run")
public class UseMavenSlf4jMojo extends AbstractMojo {
    @Override
    public void execute() {
        final var logger = LoggerFactory.getLogger(getClass().getName());
        logger.info("[inherited] This uses maven setup: " + logger.getClass() + ", " + logger.getClass().getProtectionDomain().getCodeSource().getLocation());
    }
}
