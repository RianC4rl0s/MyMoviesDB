package structures;

public class SimpleList <T> implements ListInterface<T> {
	
	public int nextId;
	
	class Node {
		
		int id;
		T data;
		Node next;
		
		public Node(T data) {
			this.id = nextId;
			nextId++;
			
			this.data = data;
			this.next = null;
		}
		
	}
	
	public Node head;
	public Node tail;
	public int size;
	
	public SimpleList() {
		head = null;
		tail = null;
		nextId = 1;
		size = 0;
	}

	@Override
	public void show() {
		
		Node p = head;
		
		if (p == null) {
			System.out.println("Empty list");
		} else {
			while (p != null) {
				System.out.println("[" + p.id + "] = " + p.data + "\n");
				p = p.next;
			}
		}
		
		System.out.println("Size: " + size);
	}
	
	@Override
	public void showReverse() {
		
		System.out.println("This is a simple linked list!");
		
	}

	@Override
	public void addFirst(T value) {
		
		Node novo = new Node(value);
		
		if (head == null) {
			head = novo;
			tail = novo;
		} else {
			novo.next = head;
			head = novo;
		}
		
		size++;
		
	}

	@Override
	public void addLast(T value) {
		
		Node novo = new Node(value);
		
		if (head == null) {
			head = novo;
			tail = novo;
		} else {
			tail.next = novo;
			tail = novo;
		}
		
		size++;
		
	}

	@Override
	public void addAfter(T value, int id) {
		
		Node p = searchNode(id);
		
		if (p == null) {
			System.out.println("Invalid");
		} else {
			Node novo = new Node(value);
			
			if (p.next == null) {
				tail = novo;
			}
			
			novo.next = p.next;
			p.next = novo;
			
			size++;
		}
		
	}

	private SimpleList<T>.Node searchNode(int id) {
		
		Node p = head;
		
		while (p != null) {
			if (p.id == id) {
				return p;
			}
			p = p.next;
		}
		
		return null;
		
	}

	@Override
	public T peekFirst() {
		
		if (head == null) {
			System.out.println("Empty list");
			return null;
		} else {
			return head.data;
		}
		
	}

	@Override
	public T peekLast() {
		
		if (tail == null) {
			System.out.println("Empty list");
			return null;
		} else {
			return tail.data;
		}
		
	}

	@Override
	public T search(int id) {
		
		Node p = searchNode(id);
		
		if (p == null) {
			return null;
		} else {
			return p.data;
		}
		
	}

	@Override
	public T removeFirst() {
		
		Node p = head;
		T dataReturned = null;
		
		if (head == null) {
			System.out.println("Empty list");
		} else {
			dataReturned = p.data;
			
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
			}
			
			p.next = null;
			size--;
		}
		
		return dataReturned;
		
	}

	@Override
	public T removeLast() {
		
		T dataReturned = null;
		
		if (tail == null) {
			System.out.println("Empty list");
			return null;
		} else {
			dataReturned = tail.data;
			
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				Node p = head;
				
				while (p.next != tail) {
					p = p.next;
				}
				
				tail = p;
				tail.next = null;
			}
			
			size--;
		}
		
		return dataReturned;
	
	}

	@Override
	public T remove(int id) {
		
		Node previous = null;
		Node removed = null;
		T dataReturned = null;
		
		if (head == null) {
			System.out.println("Empty list");
			return null;
		}
		
		previous = searchBefore(id);
		
		if (previous == null) {
			if (head.id != id) {
				System.out.println("Invalid ID");
				return null;
			} else {
				removed = head;
				
				if (head == tail) {
					head = null;
					tail = null;
				} else {
					head = head.next;
					removed.next = null;
				}
			}
		} else {
			removed = previous.next;
			
			if (removed == tail) {
				tail = previous;
				previous.next = null;
			} else {
				previous.next = removed.next;
				removed.next = null;
			}
		}
		
		dataReturned = removed.data;
		size--;
		
		return dataReturned;
		
	}

	private Node searchBefore(int id) {
		
		Node p =  head;
		Node previous = null;
		
		while (p != null) {
			previous = p;
			p = p.next;
			
			if (p != null && p.id == id) {
				return previous;
			}
		}
		
		return null;
		
	}

	@Override
	public long getSize() {
		
		return size;
		
	}

}
