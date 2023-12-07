package com.github.rmannibucau.mojo.logging.slf4j.custom;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.slf4j.LoggerFactory;

@Mojo(name = "run")
public class UseCustomMavenSlf4jMojo extends AbstractMojo {
    @Override
    public void execute() {
        final var logger = LoggerFactory.getLogger(getClass().getName());
        final var msg = "[custom] This should JDK output: " + logger.getClass() + ", " + logger.getClass().getProtectionDomain().getCodeSource().getLocation();
        if ("org.slf4j.impl.MavenSimpleLogger".equals(logger.getClass().getName())) {
            logger.error(msg);
        } else {
            logger.info(msg);
        }
        // we don't fail for demo purposes but if the output is:
        // [custom] This uses JDK output: class org.slf4j.impl.MavenSimpleLogger, file:..../lib/maven-slf4j-provider-xxxx.jar
        // then this failed
    }
}
