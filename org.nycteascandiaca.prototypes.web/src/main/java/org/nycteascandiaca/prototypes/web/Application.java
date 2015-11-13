package org.nycteascandiaca.prototypes.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.domain.Parameter;
import org.nycteascandiaca.prototypes.web.repository.ModelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.nycteascandiaca.prototypes.web")
public class Application
{	
	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		scanBeans(context);
		
		//createModels(context);
		
		//modifyModels(context);
		
		scanAllModels(context);
	}
	
	private static void scanBeans(ApplicationContext context)
	{
		System.out.println("[Begin] Scan beans");
		String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames)
        {
            System.out.println(beanName);
        }
        System.out.println("[End] Scan beans");
	}

	private static void scanAllModels(ApplicationContext context)
	{
		ModelManager modelManager = (ModelManager)context.getBean("modelManager");
		List<Model> allModels = modelManager.getAllModels();
		for (Model current : allModels)
		{
			System.out.println(toString(current));
		}
	}
	
	private static void createModels(ApplicationContext context)
	{
		ModelRepository repository = context.getBean(ModelRepository.class);
		for (int i = 1; i < 6; i++)
		{
			Model model = createModel(i);
			repository.save(model);
		}
	}
	
	private static void modifyModels(ApplicationContext context)
	{
		System.out.println("[Begin] Modify Models");
		ModelRepository repository = context.getBean(ModelRepository.class);
		for (Model model : repository.findAll())
		{
			List<Parameter> parameters = model.getParameters();
			parameters.remove(0);
			repository.save(model);
		}
		System.out.println("[End] Modify Models");
	}
	
	private static Model createModel(int index)
	{
		Model model = new Model();

		model.setName("Model " + index);

		List<Parameter> parameters = new ArrayList<Parameter>();
		for (int i = 0; i < 5; i++)
		{
			Parameter parameter = new Parameter();
			parameter.setName("Model" + index + ".Parameter");
			parameter.setValue("Value." + Integer.toString(i));
			parameters.add(parameter);
		}

		model.setParameters(parameters);
		 

		return model;
	}

	private static String toString(Model model)
	{
		StringBuffer sb = new StringBuffer();

		sb.append("Model {\n");
		sb.append("\tid: ").append(model.getId()).append("\n");
		sb.append("\tname: ").append(model.getName()).append("\n");

		sb.append("\tparameters {\n");

		for (Parameter parameter : model.getParameters())
		{
			sb.append("\t\t{name: ").append(parameter.getName());
			sb.append(", value: ").append(parameter.getValue());
			sb.append("}\n");
		}
		 
		sb.append("\t}\n}");

		return sb.toString();
	}
}
