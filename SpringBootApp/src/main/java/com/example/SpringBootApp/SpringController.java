package com.example.SpringBootApp;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SpringController {

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot Application";
	}

    @GetMapping(path = "/get-special-string-count")
    public ResultFormat customerInformation(@RequestParam(value = "str", defaultValue = "World") String str) {
    
    	Integer count = 0;
    	List<String> substrs = new ArrayList<>();
    	for (int i = 0; i < str.length(); i ++) {
    		for (int j = i + 1; j <= str.length(); j ++) {
    			String substr = str.substring(i, j);
    			if (sameCharacterCheck(substr) || sameCharExceptMiddle(substr)) {
    				count ++;
    				substrs.add(substr);
    			}
    		}
    	}
    	
    	return new ResultFormat(count, substrs);
    }
    
    public boolean sameCharacterCheck (String str) {
    	char first = str.charAt(0);
    	for (int i = 1; i < str.length(); i ++) {
    		if (first != str.charAt(i))
    			return false;
    	}
		return true;
    	
    }
    
    public boolean sameCharExceptMiddle (String str) {
    	char first = str.charAt(0);
    	for (int i = 0; i < str.length() / 2; i ++) {
    		if (first != str.charAt(i) || first != str.charAt(str.length() - 1 - i))
    			return false;
    	}
		return true;
    	
    }
}
