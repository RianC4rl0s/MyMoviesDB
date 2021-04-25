package br.com.MyMoviesDB.structures;

import exception.MyException;

public class QueueWithList <T> implements QueueInterface <T>{
	
	private ListInterface<Object> array;
	int first;
	int last;
	
	public QueueWithList() {
		this.array = new DoubleList<Object>();
	}

	@Override
	public void add(T value) throws MyException {
		
		array.addLast(value);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public T remove() {
		
		T value;
		
		if (array.getSize() == 0) {
			throw new MyException("ERR: Queue is empty");
		}
		
		value = (T) array.peekFirst();
		
		array.removeFirst();
		
		return value;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public T peek() {
		
		T value;
		
		if (array.getSize() == 0) {
			throw new MyException("ERR: Queue is empty");
		}
		
		value = (T) array.peekFirst();
		
		return value;
		
	}

	@Override
	public boolean isEmpty() {
		
		if (array.getSize() == 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean isFull() {
		
		return false;
		
	}

	@Override
	public void show() {
		
		array.show();
		
	}
}
