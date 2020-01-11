/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heila
 */
public class LinkedStack<T> implements Stack<T> {
	private Node<T> top;
        int counter;

	/* Creates a new instance of LinkStack */
	public LinkedStack() {
		top = null;
	}
        
        public boolean empty(){
		return top == null;
	}
        
        
        public T peak(){
            return top.data;
        }
        
        public boolean hasTwoElements(){
            return counter >= 2;
                
          
        }
	
	public boolean full(){
		return false;
	}
        
        public void push(T e){
		Node<T> tmp = new Node<T>(e);
		tmp.next = top;
		top = tmp;
                counter ++;
	}
        
        public T pop(){
		T e = top.data;
		top = top.next;
                counter--;
                return e;
	}
        
        public void reverse(){
            
            Stack <T> s1 = new LinkedStack<T>();
            Stack <T> s2 = new LinkedStack<T>();
            while(!empty()){
                s1.push(pop());
            }
            
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            
            while(!s2.empty()){
                push(s2.pop());
            }
            
            
            
        }
}

