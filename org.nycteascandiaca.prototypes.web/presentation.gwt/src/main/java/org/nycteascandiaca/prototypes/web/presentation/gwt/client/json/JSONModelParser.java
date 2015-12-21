package org.nycteascandiaca.prototypes.web.presentation.gwt.client.json;

import java.util.ArrayList;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;

//import com.google.gwt.json.client.JSONException;
//import com.google.gwt.json.client.JSONObject;
//import com.google.gwt.json.client.JSONTokener;

public class JSONModelParser
{
	public static final JSONModelParser INSTANCE = new JSONModelParser();
	
	private JSONModelParser()
	{
		
	}
	
/*	public List<Model> parse(String json) throws JSONException
	{
		JSONTokener jsonTokener = new JSONTokener(json);
		
		List<Model> models = new ArrayList<Model>();
		
		while(jsonTokener.more())
		{
			JSONObject jsonObject = (JSONObject)jsonTokener.nextValue();
			long id = jsonObject.getLong("id");
			String name = jsonObject.getString("name");
				
			Model model = new Model();
			model.setId(id);
			model.setName(name);
			
			models.add(model);
		}
		
		return models;
	}*/
}
