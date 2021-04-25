package structures;

import exception.MyException;

public interface QueueInterface <T> {
	
	void add(T value) throws MyException;
	T remove();
	
	T peek();
	
	boolean isEmpty();
	boolean isFull();
	
	void show();
	
}
