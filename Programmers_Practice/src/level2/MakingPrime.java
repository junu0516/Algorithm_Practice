package level2;

import java.util.Arrays;

public class MakingPrime {
	
	/*
	 * 배열 nums가 매개변수로 주어졌을 때,
	 * nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
	 * 소수가 되는 경우의 수를 return 하도록 하자
	 * 
	 * */
	
	public static int solution(int[] nums) {
		int answer = 0;
		
		Arrays.sort(nums);
		boolean[] primes = getPrime(new boolean[nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]+1]);
		
		//3개를 고르면 되니까 3중으로 반복문을 사용해도 되려나..?
		for(int i=0;i<nums.length;i++) {
			int num1 = nums[i];
			
			for(int j=i+1;j<nums.length;j++) {
				int num2 = nums[j];
				
				for(int k=j+1;k<nums.length;k++) {
					int num3 = nums[k];
					
					int sum = num1+num2+num3;
					if(!primes[sum]) {
						answer++;
					}
				}
			
			}
		}
		
		return answer;
	}

	public static boolean[] getPrime(boolean[] primes) {
		
		primes[0] = true;
		primes[1] = true;
		
		for(int i=2;i<=Math.sqrt(primes.length);i++) {
			if(primes[i]==true) {
				continue;
			}
			
			for(int j=i*2 ; j<primes.length;j+=i) {
				primes[j] = true;
			}
		}
		
		return primes;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4};
		System.out.println(solution(nums));
	}

}
