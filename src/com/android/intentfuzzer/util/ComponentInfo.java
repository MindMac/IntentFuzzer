package com.android.intentfuzzer.util;


public class ComponentInfo {
	
	private int compType = Utils.ACTIVITIES;
	
	private String componentName = null;
	
	public int getCompType(){
		return compType;
	}
	
	public void setCompType(int compType){
		this.compType = compType;
	}
	
	public String getComponentName()
	{
		return componentName;
	}
	
	public void setClassName(String componentName)
	{
		this.componentName = componentName;
	}
}


