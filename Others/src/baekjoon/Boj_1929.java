package baekjoon;

import java.util.Scanner;

public class Boj_1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		/*
		 * 에라토스테네스의 체(소수판별시, 처음붙터 끝까지 살펴보는 것보다 더 효율적)
		 * 
		 * 소수 판별을 위한 배열을 먼저 할당 후,
		 * 2 이상의 수의 배수에 해당하는 수를 모두 지워주면,
		 * 남아있는 수들이 소수가 됨
		 * 
		 * */
		boolean[] primes = new boolean[n+1]; //i가 소수가 아닌 경우 primes[i] = true로 간주
		getPrime(primes); //함수 호출 후 primes[i] = false인  i에 대해서 모두 소수인 것으로 간주
		
		StringBuffer sb = new StringBuffer();
		for(int i=m;i<=n;i++) {
			if(primes[i]==false) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb.toString());
		
	}
	
	/*에라토스테네스의 체*/
	public static void getPrime(boolean[] primes) {
		primes[0] = true;
		primes[1] = true; //1은 소수가 아니기 때문에 따로 처리
		
		for(int i=2;i<primes.length;i++) { //2부터 시작해서 특정 수의 배수에 해당하는 수를 지워주는 작업을 수행하게 됨
			if(primes[i]==true) { //먼저, 이미 소수로 판별난 것은 건너뜀
				continue;
			}
			
			for(int j=2*i;j<primes.length;j+=i) { //i의 2배수, 3배수 4배수...를 모두 지워줌(2*i부터 시작해서 i씩 더해주는 반복문)
				primes[j] = true;
			}
		}
	}
}
