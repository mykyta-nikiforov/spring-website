package io.nikiforov.edu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class CourseApiApp extends SpringBootServletInitializer
        implements WebApplicationInitializer {
    private static final Logger logger = LogManager.getLogger(CourseApiApp.class);
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(CourseApiApp.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
        System.out.println("Hello!");
        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Warning!");
        logger.error("Error log");
        logger.fatal("Fatall error");
    }
}