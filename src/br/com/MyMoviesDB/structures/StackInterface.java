package br.com.MyMoviesDB.structures;

import exception.MyException;

public interface StackInterface <T>{
	
	void push(T value) throws MyException;
	T pop() throws MyException;
	
	T peek() throws MyException;
	
	boolean isEmpty();
	boolean isFull();
	
	void show();
}
