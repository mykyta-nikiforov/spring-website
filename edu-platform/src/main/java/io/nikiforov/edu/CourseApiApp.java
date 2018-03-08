package io.nikiforov.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class CourseApiApp extends SpringBootServletInitializer
        implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(CourseApiApp.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args);
        System.out.println("Hello!");
    }

}
