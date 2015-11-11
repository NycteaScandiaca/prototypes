package org.nycteascandiaca.prototypes.web.business;

import org.nycteascandiaca.prototypes.web.business.impl.ModelManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfigutation
{
	@Bean
	public ModelManager modelManager()
	{
		return new ModelManagerImpl();
	}
}
