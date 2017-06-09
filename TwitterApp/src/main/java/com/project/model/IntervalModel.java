package com.project.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class IntervalModel
{
	@NotNull
	private String username = null;
	@Min(1)
	private int count;
    private String content = null;
	@NotNull
    private String since = null;
	@NotNull
    private String until = null;

    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public String getSince()
    {
    	return since;
    }

    public void setSince(String since)
    {
    	this.since = since;
    }
    
    public String getUntil()
    {
    	return until;
    }
    
    public void setUntil(String until)
    {
    	this.until = until;
    }

}
