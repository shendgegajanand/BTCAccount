package com.anymind.gajanand.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AnyMindPropertyUtility {

	@Autowired
    private Environment env;

    public String getProperty(String pPropertyKey) {
        return env.getProperty(pPropertyKey);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
