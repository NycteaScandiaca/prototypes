package org.nycteascandiaca.prototypes.web.presentation.shared;

public class ParameterInfo
{
	private Long id;
	
	private String name;
	
	private String value;
	
	public ParameterInfo()
	{
		
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
	
	public String getValue()
	{
		return value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
}
