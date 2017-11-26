import java.util.*;
import java.lang.*;
import java.io.*;
 
class BinarySearchTree <Key extends Comparable<Key>, Value> {
	
	Scanner sc = new Scanner(System.in);
	int poiskchisla = sc.nextInt();
	int nenaideno=0;
	int Mylevel=0;
	private class Node {
		Key key;
		Value value;
		Node left, right;
		public Node (Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = this.right = null;
		}
	}
	private Node root;
	
	private Node add(Node node, Key key, Value value) {
		if (node == null) node = new Node(key, value);
		else {
			int compareResult = key.compareTo(node.key);
	        if(compareResult < 0) node.left = add(node.left, key, value);
    	    else if (compareResult == 0) node.value = value; 
        	else node.right = add(node.right, key, value);
		}
        return node;
	}
	public void add(Key key, Value value) {
		root = add(root, key, value);
	}
        
	/*public Key MinKey(){
        Node cur = root;
        while (cur.left != null) cur = cur.left;
        return cur.key;
    }
    
	public Key MaxKey(){
        Node cur = root;
        while (cur.right != null) cur = cur.right;
        return cur.key;
    }
 
	public void delete(Key key) {
        Node cur = root;
        Node prev = null;
        while (true) {
            if (cur == null) return;
            int compareResult = key.compareTo(cur.key);
            if (compareResult < 0) {
                prev = cur; 
                cur = cur.left;
            }
            else if (compareResult == 0) break;
            else {
            	prev = cur;
                cur = cur.right;
            }
        }
        if (cur.right == null) {
        	if (cur == prev.left) prev.left = cur.left;
        	else prev.right = cur.left;
        }
        else {
        	Node minFromRight = cur.right;
        	prev = null;
        	while (minFromRight.left != null) {
        		prev = minFromRight;
        		minFromRight = minFromRight.left;
        	}
        	if (prev == null) cur.right = minFromRight.right;
        	else prev.left = minFromRight.right;
        	cur.key = minFromRight.key;
        	cur.value = minFromRight.value;
        }
	}
	*/
	public Value get(Key key) {
        Node cur = root;
        while (true) {
            if (cur == null) break;
            int compareResult = key.compareTo(cur.key);
            if (compareResult < 0) cur = cur.left;
            else if (compareResult == 0) break;
            else cur = cur.right;
        }
        return cur == null ? (Value)null : cur.value;
	}
	
	public void print(Node node, int level) {
		if (node != null) {
			print(node.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("\t");
			}
						
			if((int)node.key==poiskchisla) {
				System.out.println(node.key+"|ту("+level+")|");
				nenaideno=1;
				Mylevel=level;
			}else {
				System.out.println(node.key);
			}
			//System.out.println(node.key + " -> " + node.value); 
			print(node.left, level + 1);
		}
		//System.out.println(poiskchisla);

	}
	
	public void print() {
		print(root, 0);
		if (nenaideno==0) {
		System.out.println("Число не найдено");
		
	}else {
		System.out.println("Число найдено!");
		System.out.println("Число узлов: "+Mylevel);
	}
	}
}
 
class Ideone {
	public static void main (String[] args) {
		System.out.println("Введите число для поиска:");
		BinarySearchTree<Integer, Integer> a = new BinarySearchTree<Integer, Integer>();
		int n = 80;
		for(int i = 0; i < n; i++) {
			a.add((int)(Math.random()*16), (int)(Math.random()*1000));
		}
		//System.out.println(a.MaxKey() + " -> " + a.get(a.MaxKey()));
		//System.out.println(a.MinKey() + " -> " + a.get(a.MinKey()));
		a.print();
		System.out.println("\n\n");
		Integer x = (int)(Math.random()*16);
		System.out.println(x);
		System.out.println("\n\n");
	//	a.delete(x);
		a.print();
		
	}
}