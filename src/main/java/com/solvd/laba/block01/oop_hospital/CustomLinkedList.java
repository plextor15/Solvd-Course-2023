package com.solvd.laba.block01.oop_hospital;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T> {
	private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
	private Node<T> head;
	private int size = 0;

	private static class Node<T> {
		//private static final Logger LOGGER = LogManager.getLogger(Node.class);
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}

	public T get(int index) {
		Node<T> current = head;
		for (int i = 0; i < index && current != null; i++) {
			current = current.next;
		}

		if (current != null) {
			return current.data;
		}

		return null;
	}

	public void remove(T data) {
		if (head == null) {
			return;
		}

		if (head.data.equals(data)) {
			head = head.next;
			return;
		}

		Node<T> current = head;
		while (current.next != null && !current.next.data.equals(data)) {
			current = current.next;
		}

		if (current.next != null) {
			current.next = current.next.next;
		}
	}

	public void remove(int index) {
		this.remove(this.get(index));
	}

	public int size() {
		return size;
	}

	// For debug
	public void printOut() {
		Node<T> current = head;
		while (current != null) {
			LOGGER.info("- " + current.data + "\n");
			current = current.next;
		}
	}
}
