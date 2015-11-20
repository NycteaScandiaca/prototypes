package org.nycteascandiaca.prototypes.web.domain;

import java.util.ArrayList;
import java.util.List;

public class Model
{
	private long id;
	
	private String name;
	
	private List<Parameter> parameters;
	
	public Model()
	{
		parameters = new ArrayList<Parameter>(0);
	}
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public List<Parameter> getParameters()
	{
		return parameters;
	}
	
	public void setParameters(List<Parameter> parameters)
	{
		this.parameters = parameters;
	}
}
