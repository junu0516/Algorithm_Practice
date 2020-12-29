package baekjoon;

import java.util.Scanner;

public class Boj_11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] pack = new int[n+1];
		int[] max = new int[n+1];
		for(int i=1;i<=n;i++) {
			pack[i] = sc.nextInt();
		}
		
		max[1] = pack[1];
		
		if(n>=2) {
			max[2] = Math.max(max[1]+pack[1], pack[2]);
			for(int i=3;i<=n;i++) {
				max[i] = pack[i];
				for(int j=i-1;j>=1;j--) {
					max[i] = Math.max(max[j]+pack[i-j], max[i]);
				}
			}
		}
		
		int result = max[n];
		System.out.println(result);
	}
}
