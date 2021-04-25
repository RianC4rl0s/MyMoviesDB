package structures;

import exception.MyException;

public class Queue <T> implements QueueInterface <T>{
	
	int size;
	private Object[] array;
	int first;
	int last;
	
	public Queue(int size) {
		this.first = -1;
		this.last = -1;
		this.size = size;
		this.array = new Object[size];
	}

	@Override
	public void add(T value) throws MyException {
		
		int lastIndex  = (last + 1) % size; // operação que realiza o movimento circular
		
		if (lastIndex == first) {
			throw new MyException("ERR: Queue is full");
		}
		
		array[lastIndex] = value;
		last = lastIndex;
		
		if (first == -1) {
			first = 0;
		}
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public T remove() {
		
		T value;
		
		if (first == -1) {
			throw new MyException("ERR: Queue is empty");
		}
		
		value = (T) array[first];
		
		if (first == last) 
		{
			first = -1;
			last = -1;
		} else {
			first = (first + 1) % size;
		}
		
		return value;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public T peek() {
		
		T value;
		
		if (first == -1) {
			throw new MyException("ERR: Queue is empty");
		}
		
		value = (T) array[first];
		
		return value;
		
	}

	@Override
	public boolean isEmpty() {
		
		if (first == -1) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean isFull() {
		
		int lastIndex = (last + 1) % size;
		
		if (lastIndex == first) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public void show() {
		
		int i = first;
		
		if (first == -1) {
			return;
		}
		
		while(i != last)
	    {
			System.out.println("[" + i + "] = " + array[i] + "\n");
	        i++;

	        if (i == size) {
	            i = 0;
	        }
	    }
		
		System.out.println("[" + i + "] = " + array[i] + "\n");
		
	}

}
