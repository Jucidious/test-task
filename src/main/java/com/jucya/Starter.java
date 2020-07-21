package com.jucya;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Runs the {@code TestTask} application.
 */
@SpringBootApplication
@EnableConfigurationProperties
public class Starter {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Starter.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
