package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_10866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> deque = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			String order = st.nextToken();
			if(order.equals("push_front")) {
				int x = Integer.parseInt(st.nextToken());
				deque.addFirst(x);
			}else if(order.equals("push_back")) {
				int x = Integer.parseInt(st.nextToken());
				deque.addLast(x);
			}else if(order.equals("pop_front")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.pollFirst()+"\n");
				}
			}else if(order.equals("pop_back")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.pollLast()+"\n");
				}
			}else if(order.equals("size")) {
				sb.append(deque.size()+"\n");
			}else if(order.equals("empty")) {
				if(deque.isEmpty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
			}else if(order.equals("front")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.peekFirst()+"\n");
				}
			}else if(order.equals("back")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.peekLast()+"\n");
				}
			}
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
