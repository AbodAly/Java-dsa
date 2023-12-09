
import java.util.ArrayList;
import java.util.EmptyStackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class StackArrayList {
	static void main(){
	 StackArrayList stack = new StackArrayList();
        assert stack.isEmpty();

        for (int i = 1; i <= 5; ++i) {
            stack.push(i);
            assert stack.size() == i;
        }

        assert stack.size() == 5;
        assert stack.peek() == 5 && stack.pop() == 5 && stack.peek() == 4;

        /* pop elements at the top of this stack one by one */
        while (!stack.isEmpty()) {
            stack.pop();
        }
        assert stack.isEmpty();

        try {
            stack.pop();
            assert false;
            /* this should not happen */
        } catch (EmptyStackException e) {
            assert true;
            /* this should happen */
        }	
	}
	private ArrayList<Integer> stack; 
	public StackArrayList(){
		stack = new ArrayList<>(); 
	}
	public int pop(){

		if(isEmpty()){
			throw new EmptyStackException();
		}
		return stack.remove(stack.size() - 1 );
	}
	public void push(int value ){
		stack.add(value);
	}
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	public int peek(){
		return stack.get(stack.size()-1);
	}
	public int size(){
		return stack.size();
	}
}
