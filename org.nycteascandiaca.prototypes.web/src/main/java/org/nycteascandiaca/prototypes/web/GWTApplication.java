package org.nycteascandiaca.prototypes.web;

import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.nycteascandiaca.prototypes.web")
public class GWTApplication
{
	public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run(GWTApplication.class, args);
		
		ModelManager modelManager = (ModelManager)context.getBean("modelManager");
		List<Model> allModels = modelManager.getAllModels();
		for (Model current : allModels)
		{
			System.out.println(toString(current));
		}
	}
	
	/*public static void main(String[] args)
	{
		ConfigurableApplicationContext context = SpringApplication.run("classpath:/spring/application-context.xml", args);
		
		scanBeans(context);
		
//		ModelRepository repository = context.getBean(ModelRepository.class);
//
//		for (int i = 1; i < 6; i++)
//		{
//			Model model = createModel(i);
//			repository.save(model);
//		}
//		
//		List<Model> allModels = repository.findAll();
//		for (Model current : allModels)
//		{
//			System.out.println(toString(current));
//		}
		
		ModelManager modelManager = (ModelManager)context.getBean("modelManager");
		List<Model> allModels = modelManager.getAllModels();
		for (Model current : allModels)
		{
			System.out.println(toString(current));
		}
	}*/
	
	private static void scanBeans(ConfigurableApplicationContext context)
	{
		for (String beanDefinitionName : context.getBeanDefinitionNames())
		{
			System.err.println(beanDefinitionName);
		}
	}

	private static Model createModel(int index)
	{
		Model model = new Model();

		model.setName("Model " + index);

//		
//		  List<Parameter> parameters = new ArrayList<Parameter>(); for (int i =
//		  0; i < 5; i++) { Parameter parameter = new Parameter();
//		  parameter.setName("Model" + index + ".Parameter");
//		  parameter.setValue(Integer.toString(i)); parameters.add(parameter); }
//		  
//		  model.setParameters(parameters);
		 

		return model;
	}

	private static String toString(Model model)
	{
		StringBuffer sb = new StringBuffer();

		sb.append("Model {\n");
		sb.append("\tid: ").append(model.getId()).append("\n");
		sb.append("\tname: ").append(model.getName()).append("\n");

		sb.append("\tparameters {\n");
		
//		 for (Parameter parameter : model.getParameters()) { sb.append(
//		  "\t\t{id: ").append(parameter.getId()); sb.append(", name: "
//		  ).append(parameter.getName()); sb.append(", value: "
//		  ).append(parameter.getValue()); sb.append("}\n"); }
//		 
		sb.append("\t}\n}");

		return sb.toString();
	}
}
