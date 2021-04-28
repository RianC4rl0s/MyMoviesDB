package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;

public class AvaliadorVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5081678849308500358L;
	
	private int key;
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "[" + name + ", key = " + key + "]";
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}
