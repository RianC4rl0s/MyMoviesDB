package structures;

public interface ListInterface <T> {

	void show();
	void showReverse();
	
	long getSize();
	
	void addFirst(T value);
	void addLast(T value);
	void addAfter(T value, int id);
	
	void updateData(T value, int id);
	
	T peekFirst();
	T peekLast();
	
	T search(int id);
	
	T removeFirst();
	T removeLast();
	T remove(int id);
	
}
