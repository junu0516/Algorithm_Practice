package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>(); //최종 수열
		Queue<Integer> queue = new LinkedList<Integer>(); //임시 수열
		for(int i=0;i<n;i++) {
			queue.add(i+1);
		}
		
		for(int i=1;i<=n;i++) {//한 번에 k번씩, 리스트의 길이 n만큼 총 n*k번을 돌아야 함
			for(int j=1;j<=k;j++) {
				int curr = queue.poll();
				if(j%k==0) {
					list.add(curr);
				}else {
					queue.add(curr);
				}
			}
		}
		
		System.out.print("<");
		for(int i=0;i<list.size();i++) {
			if(i==list.size()-1) {
				System.out.print(list.get(i));
			}else {
				System.out.print(list.get(i)+", ");
			}
		}
		System.out.print(">");
		
	}
}
