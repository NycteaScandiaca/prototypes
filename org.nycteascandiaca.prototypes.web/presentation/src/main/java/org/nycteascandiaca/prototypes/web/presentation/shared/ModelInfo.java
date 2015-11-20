package org.nycteascandiaca.prototypes.web.presentation.shared;

import java.util.ArrayList;
import java.util.List;

public class ModelInfo
{
	private Long id;
	
	private String name;
	
	private List<ParameterInfo> parameters;
	
	
	public ModelInfo()
	{
		parameters = new ArrayList<ParameterInfo>();
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
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
	
	public List<ParameterInfo> getParameters()
	{
		return parameters;
	}
}
