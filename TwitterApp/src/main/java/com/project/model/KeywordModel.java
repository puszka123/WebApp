package com.project.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class KeywordModel
{
	@NotNull
	private String username = null;
	@Min(1)
	private int count;
    private String content = null;
    @NotNull
    private String keyword = null;
    

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
    
    public String getKeyword()
    {
    	return keyword;
    }
    
    public void setKeyword(String keyword)
    {
    	this.keyword = keyword;
    }
}
