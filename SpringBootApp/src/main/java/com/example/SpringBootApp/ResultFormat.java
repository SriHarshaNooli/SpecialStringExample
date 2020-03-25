package com.example.SpringBootApp;

import java.util.List;

public class ResultFormat {

	public ResultFormat(Integer count, List<String> substrs) {
		// TODO Auto-generated constructor stub
		this.count = count;
		this.strings = substrs;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getStrings() {
		return strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}

	int count;
	
	List<String> strings;
}
