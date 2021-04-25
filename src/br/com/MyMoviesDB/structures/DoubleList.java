package br.com.MyMoviesDB.structures;

public class DoubleList <T> implements ListInterface<T> {
	
	public int nextId;
	
	class Node {
		
		int id;
		T data;
		Node next;
		Node prev;
		
		public Node(T data, Node prev) {
			this.id = nextId;
			nextId++;
			
			this.data = data;
			this.next = null;
			this.prev = prev;
		}
		
	}
	
	public Node head;
	public Node tail;
	public int size;
	
	public DoubleList() {
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
		
		Node p = tail;
		
		if (p == null) {
			System.out.println("Empty list");
		} else {
			while (p != null) {
				System.out.println("[" + p.id + "] = " + p.data + "\n");
				p = p.prev;
			}
		}
		
		System.out.println("Size: " + size);
	}

	@Override
	public void addFirst(T value) {
		
		Node novo = new Node(value, null);
		
		if (head == null) {
			head = novo;
			tail = novo;
		} else {
			novo.next = head;
			head.prev = novo;
			head = novo;
		}
		
		size++;
		
	}

	@Override
	public void addLast(T value) {
		
		Node novo = new Node(value, tail);
		
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
			Node novo = new Node(value, p);
			
			if (p.next == null) {
				tail = novo;
			}
			
			novo.next = p.next;
			p.next = novo;
			
			size++;
		}
		
	}

	private DoubleList<T>.Node searchNode(int id) {
		
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
				head.prev = null;
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
				Node previous = tail.prev;
				tail.prev = null;
				tail = previous;
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
		
		previous = searchNode(id).prev;
		
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
					head.prev = null;
					removed.next = null;					
				}
			}
		} else {
			removed = previous.next;
			
			if (removed == tail) {
				tail.prev = null;
				tail = previous;
				tail.next = null;
			} else {
				previous.next = removed.next;
				removed.next.prev = null;
				removed.prev = null;
				removed.next = null;
			}
		}
		
		dataReturned = removed.data;
		size--;
		
		return dataReturned;
		
	}

	@Override
	public long getSize() {
		
		return size;
		
	}

}
