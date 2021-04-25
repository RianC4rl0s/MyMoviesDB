package structures;

import exception.MyException;

public class StackWithList <T> implements StackInterface <T>{
	
	private ListInterface<Object> array;
	
	public StackWithList() {
		this.array = new DoubleList<Object>();
	}

	@Override
	public void push(T value) {
		
		array.addFirst(value);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public T pop() throws MyException {
		
		T value;
		
		if (array.getSize() ==  0) {
			throw new MyException("ERR: Stack is empty!");
		}
		
		value = (T) array.removeFirst();
		
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")	
	public T peek() throws MyException {
		
		return (T) array.peekFirst();
		
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
	
	public void show() {
		
		array.show();
		
	}

}
