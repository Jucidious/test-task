package com.jucya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Runs the {@code TestTask} application.
 *
 * @since 0.1
 */
@SpringBootApplication
@EnableConfigurationProperties
public class Starter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class.getName());

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Starter.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
