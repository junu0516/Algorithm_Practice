package baekjoon;

import java.util.Scanner;

public class Boj_2745 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String b = sc.next();
		int n = sc.nextInt();
		
		int result = 0;
		for(int i=0;i<b.length();i++) {
			if(b.charAt(i)>='0' && b.charAt(i)<='9') {
				result = result*n+(b.charAt(i)-'0');
			}else {
				result = result*n+(b.charAt(i)-'A'+10);
			}
		}
		System.out.println(result);
	}
}
