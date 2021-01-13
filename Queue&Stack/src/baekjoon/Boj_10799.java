package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Boj_10799 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] arr = input.toCharArray();
		Stack<Integer> stack = new Stack<>();
		// ( ) ( ( ( ( ) ( ) ) ( ( ) ) ( ) ) ) ( ( ) )
	    /*
	     * 	L         L   L       L     L         L
	     *     o ----------------------------o
	     * 		 o-------------------------o
	     *         o---------o 
	     *                     o-----o
	     *                                     o-----o 
	     *
	     *   ( ( (   ) (  )  ) ) (  )
	     *                                       
	     * */    
		
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='(') {
				stack.add(i);
			}else{
				if(stack.peek() == i-1) {
					stack.pop();
					count+= stack.size();
				}else {
					stack.pop();
					count++;
				}
			}			
		}
		
		System.out.println(count);
	}
}
