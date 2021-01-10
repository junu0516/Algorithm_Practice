package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_11866 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> table = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			table.add(i+1);
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(j%k==0) {
					list.add(table.poll());
				}else {
					int temp = table.poll();
					table.add(temp);//후순위로 다시 넣어줌
				}
			}
		}
		
		System.out.print("<");
		for(int i=0;i<list.size();i++) {
			if(i!=list.size()-1) {
				System.out.print(list.get(i)+", ");
			}else {
				System.out.print(list.get(i));
			}
		}
		System.out.print(">");
	}

}
