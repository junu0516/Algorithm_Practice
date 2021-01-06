package baekjoon;

import java.util.*;
import java.io.*;

public class Boj_10828{
	public static void main(String[]args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Stack<Integer> stack = new Stack<Integer>();
		
		int size = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.contains("push")) {
				int input = Integer.parseInt(st.nextToken());
				stack.push(input);
				
			}
			else if(order.contains("pop")) {
				int num = (stack.empty())? -1:stack.pop();
				System.out.println(num);
			}
			else if(order.contains("size")) {
				int num = stack.size();
				System.out.println(num);
			}				
			else if(order.contains("empty")) {
				int num = (stack.empty())? 1:0;
				System.out.println(num);
			}
			else if(order.contains("top")) {
				int num = (stack.empty())? -1:stack.peek();
				System.out.println(num);
			}	
		}
		br.close();
	}
}