package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_6588 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		boolean[] primes = new boolean[1000001];
		getPrime(primes); //소수판별을 위한 에라토스테네스의 체는 1번만 실행하면 됨

		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				break;
			}
					
			int a = 0;
			int b = 0;
			for(int i=0;i<primes.length;i++) {
				if(primes[i]==false && primes[num-i]==false) {
					//반복문을 여러번 돌릴 필요 없이 b-a의 최소값은 결국 a와 b가 모두 소수인 상황에서, a가 최소가 되는 상황임
					//따라서 a와 b가 모두 소수인 조건을 최초로 만족하는 경우의 a가 최소기 때문에 해당 조건 1회 만족시 바로 반복문을 빠져나가는 것이 효율적
					a = i;
					b = num-i;
					break;
				}
			}
			
			if(a==0&&b==0) {
				sb.append("Goldbach's conjecture is wrong."+"\n");
			}else {
				sb.append(num+" = "+a+" + "+b+"\n");
			}			
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}
	
	public static void getPrime(boolean[] primes) {
		primes[0] = true;
		primes[1] = true;
		
		for(int i=2;i<Math.sqrt(primes.length);i++) { //에라토스테네스의 체 실행시 상위 반복문은 숫자의 제곱근까지만 돌면 됨(하위 반복문에서 그 이상의 수는 이미 다 판별되었기 때문)
			if(primes[i]==true) {
				continue;
			}
			
			for(int j=2*i;j<primes.length;j+=i) {
				primes[j] = true;
			}
		}
	}

}
