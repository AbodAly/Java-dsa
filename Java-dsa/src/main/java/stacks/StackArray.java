/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

/**
 *
 * @author pc
 */
public class StackArray {

	public static void main(String[] args) {
		// Declare a stack of maximum size 4
		StackArray myStackArray = new StackArray(4);

		assert myStackArray.isEmpty();
		assert !myStackArray.isFull();

		// Populate the stack
		myStackArray.push(5);
		myStackArray.push(8);
		myStackArray.push(2);
		myStackArray.push(9);

		assert !myStackArray.isEmpty();
		assert myStackArray.isFull();
		assert myStackArray.peek() == 9;
		assert myStackArray.pop() == 9;
		assert myStackArray.peek() == 2;
		assert myStackArray.size() == 3;
	}

	private static final int DEFFUALT_CAPACITY = 10;
	private int max_size;
	private int[] stackArray;
	private int top;
	// constructor uising deffualt capcity & constructor using int size 

	public StackArray() {
		this(DEFFUALT_CAPACITY);
	}

	public StackArray(int size) {
		top = -1;
		stackArray = new int[size];
		max_size = size;
	}

	public void push(int value) {
		if (!isFull()) {
			top++;
			stackArray[top] = value;
		} else {
			resize(max_size * 2);
			push(value);
		}
	}

	public int pop() {
		if (!isEmpty()) {
			return stackArray[top--];
		}
		if (top < max_size / 4) {
			resize(max_size / 2);
			return pop();
		} else {
			System.out.println("The stack is already empty ");
			return -1;
		}

	}

	public int peek() {
		if (isEmpty()) {
			System.out.print("the stack is already empty");
			return -1;
		}
		return stackArray[top];
	}

	private void resize(int newSize) {
		int[] transArray = new int[newSize];
		for (int i = 0; i <= top; i++) {
			transArray[i] = stackArray[i];
		}
		stackArray = transArray;
		max_size = newSize;

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top + 1 == max_size);
	}

	public void makeEmpty() {
		top = -1;
	}

	public int size() {
		return top + 1;
	}

}
