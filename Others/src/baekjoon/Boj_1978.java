package baekjoon;

import java.util.Scanner;

public class Boj_1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			max = Math.max(arr[i], max);
		}
		
		boolean[] primes = new boolean[max+1];
		getPrime(primes);
		
		int result=0;
		for(int i=0;i<arr.length;i++) {
			if(primes[arr[i]]==false) {
				result++;
			}
		}
		System.out.println(result);	
	}
	
	/*에라토스테네스의 체*/
	public static void getPrime(boolean[] primes) {
		primes[0] = true;
		primes[1] = true;
		
		for(int i=2;i<primes.length;i++) {
			if(primes[i] == true) {
				continue;
			}
			
			for(int j=2*i;j<primes.length;j+=i) {
				primes[j] = true;
			}
		}
	}
}