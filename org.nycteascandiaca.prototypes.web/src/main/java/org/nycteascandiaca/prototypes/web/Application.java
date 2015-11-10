package org.nycteascandiaca.prototypes.web;

import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.repository.ModelRepository;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application
{
	public static void main(String[] args)
	{
		try (GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/application-context.xml"))
		{
			ModelRepository repository = ctx.getBean(ModelRepository.class);

			/*for (int i = 1; i < 6; i++)
			{
				Model model = createModel(i);
				repository.save(model);
			}
			
			/*List<Model> allModels = repository.findAll();
			for (Model current : allModels)
			{
				System.out.println(toString(current));
			}*/
			
			ModelManager modelManager = (ModelManager)ctx.getBean("modelManager");
			List<Model> allModels = modelManager.getAllModels();
			for (Model current : allModels)
			{
				System.out.println(toString(current));
			}
		}
	}
	
	private static Model createModel(int index)
	{
		Model model = new Model();
		
		model.setName("Model " + index);

		/*List<Parameter> parameters = new ArrayList<Parameter>();
		for (int i = 0; i < 5; i++)
		{
			Parameter parameter = new Parameter();
			parameter.setName("Model" + index + ".Parameter");
			parameter.setValue(Integer.toString(i));
			parameters.add(parameter);
		}
		
		model.setParameters(parameters);*/
		
		return model;
	}
	
	private static String toString(Model model)
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("Model {\n");
		sb.append("\tid: ").append(model.getId()).append("\n");
		sb.append("\tname: ").append(model.getName()).append("\n");
		
		sb.append("\tparameters {\n");
		/*for (Parameter parameter :  model.getParameters()) {
			sb.append("\t\t{id: ").append(parameter.getId());
			sb.append(", name: ").append(parameter.getName());
			sb.append(", value: ").append(parameter.getValue());
			sb.append("}\n");
		}*/
		sb.append("\t}\n}");
		
		return sb.toString();
	}
}
