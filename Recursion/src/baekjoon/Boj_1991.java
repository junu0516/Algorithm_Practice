package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class Boj_1991 {
	static HashMap<String,String[]> tree = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		for(int i=0;i<n;i++) {
			String data = sc.next();
			String left = sc.next();
			String right = sc.next();
			
			String[] child = new String[2];
			child[0] = left;
			child[1] = right;
			tree.put(data, child);
		}
		//pre
		pre("A");
		System.out.println();
		in("A");
		System.out.println();
		pro("A");
	}
	
	public static void pre(String v) {
		if(v.equals(".")) { //자식 노드가 없을 경우 순회 종료
			return;
		}
	
		System.out.print(v);
		pre(tree.get(v)[0]); //왼쪽 자식 노드 순회	
		pre(tree.get(v)[1]); //오른쪽 자식 노드 순회
	}	
	
	public static void in(String v) {
		if(v.equals(".")) {
			return;
		}
		
		in(tree.get(v)[0]);
		System.out.print(v);
		in(tree.get(v)[1]);
	}
	
	public static void pro(String v) {
		if(v.equals(".")) {
			return;
		}
		
		pro(tree.get(v)[0]);
		pro(tree.get(v)[1]);
		System.out.print(v);
	}
}
