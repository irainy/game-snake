public class DoublyLinkedList<T> {
	class TNode {
		TNode next = null;
		TNode prev = null;
		T object;
	}

	TNode head = null, tail = null;
	TNode cur = null;
	int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public T getFirst() {
		return head.object;
	}

	public T getLast() {
		return tail.object;
	}

	public void addFirst(T p) {
		TNode head = new TNode();
		head.object = p;
		if (size == 0) {
			this.head = head;
			this.tail = head;
		} else {
			this.head.prev = head;
			head.next = this.head;
			this.head = head;
		}

		size++;
	}

	public void addLast(T p) {
		TNode tail = new TNode();
		tail.object = p;
		if (size == 0) {
			this.head = tail;
			this.tail = head;
		} else {
			this.tail.next = tail;
			tail.prev = this.tail;
			this.tail = tail;
		}

		size++;
	}

	public T removeFirst() {
		if (size == 0)
			return null;
		T obj = this.head.object;
		this.head = this.head.next;
		this.head.prev = null;
		size--;

		return obj;
	}

	public T removeLast() {
		if (size == 0)
			return null;
		T obj = this.tail.object;
		this.tail = this.tail.prev;
		this.tail.next = null;
		size--;

		return obj;
	}

	public String toString() {
		return "This is a DoublyLinkedList of <T>!";
	}
}
