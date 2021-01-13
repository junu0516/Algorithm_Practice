package baekjoon;

import java.util.*;
import java.io.*;

public class Boj_10845 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int back = -1;
		
		for(int i=0;i<n;i++) {			
			String order = br.readLine();
			
			if(order.contains("push")) {
				back = Integer.parseInt(order.substring(5));
				queue.add(back);
				
			}else if(order.equals("pop")) {
				
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(queue.poll()+"\n");
				}
				
			}else if(order.equals("size")) {
				
				bw.write(queue.size()+"\n");
				
			}else if(order.equals("empty")) {
				
				if(queue.isEmpty()) {
					bw.write(1+"\n");
				}else {
					bw.write(0+"\n");
				}
				
			}else if(order.equals("front")) {
				
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(queue.peek()+"\n");
				}
				
			}else if(order.equals("back")) {
				
				if(queue.isEmpty()) {
					bw.write(-1+"\n");
				}else {
					bw.write(back+"\n");
				}
				
			}					
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
