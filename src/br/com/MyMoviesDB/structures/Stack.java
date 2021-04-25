package br.com.MyMoviesDB.structures;

import exception.MyException;

public class Stack <T> implements StackInterface <T>{
	
	int size;
	private Object[] array;
	int top;
	
	public Stack(int size) {
		this.top = -1;
		this.size = size;
		this.array = new Object[size];
	}

	@Override
	public void push(T value) throws MyException {
		
		if (top == size - 1) {
			throw new MyException("ERR: Stack is full!");
		}
		
		top++;
		array[top] = value;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public T pop() throws MyException {
		
		T value;
		
		if (top ==  -1) {
			throw new MyException("ERR: Stack is empty!");
		}
		
		value = (T) array[top];
		top--;
		
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T peek() throws MyException {
		
		T value;
		
		if (top == -1) {
			throw new MyException("ERR: Stack is empty!");
		}
		
		value = (T) array[top];
		
		return value;
	}

	@Override
	public boolean isEmpty() {
		
		if (top == -1) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean isFull() {
		
		if (top == size - 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void show() {
		
		for (int i = 0; i <= top; i++) {
			System.out.println("[" + i + "] = " + array[i] + "\n");
		}
		
	}

}
