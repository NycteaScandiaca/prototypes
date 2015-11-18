package org.nycteascandiaca.prototypes.web.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.nycteascandiaca.prototypes.web")
public class Application extends SpringBootServletInitializer
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
        return application.sources(Application.class);
    }
	
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
