package structures;

import exception.MyException;

public class QueueWithList <T> implements QueueInterface <T>{
	
	private ListInterface<T> array;
	int first;
	int last;
	
	public QueueWithList() {
		this.array = new DoubleList<T>();
	}

	@Override
	public void add(T value) throws MyException {
		
		array.addLast(value);
		
	}

	@Override
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

	@Override
	public int peekLastId() {
		return array.peekLastId();
	}

	@Override
	public T search(int id) {
		return array.search(id);
	}
}
