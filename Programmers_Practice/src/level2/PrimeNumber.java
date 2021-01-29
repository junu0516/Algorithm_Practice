package level2;

import java.util.TreeSet;

public class PrimeNumber {
	
	public static int solution(String numbers) {
		int[] values = new int[numbers.length()];
		boolean[] visited = new boolean[numbers.length()];
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i=0;i<values.length;i++) {
			values[i] = Integer.parseInt(numbers.substring(i,i+1));
		}
		
		for(int i=0;i<values.length;i++){
			int[] list = new int[i+1];
			permutation(values,visited,0,i+1,-1,list,set);
		}
		
		int answer = getPrime(set);
		
		return answer;
	}
	
	public static void permutation(int[] values, boolean[] visited, int depth, int length, int com, int[] list, TreeSet<Integer> set) {
		if(depth == length) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<list.length;i++) {
				sb.append(list[i]);
			}
			String result = sb.toString();
			if(result.length()>=1) {
				set.add(Integer.parseInt(result));
			}
			return;
		}
		
		for(int i=0;i<values.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				list[depth] = values[i];
				permutation(values,visited,depth+1,length,i,list,set);
				visited[i] = false;
			}
		}
	}
	
	
	public static int getPrime(TreeSet<Integer> set) {
		int answer = 0;
		int length = set.last();
		
		boolean[] primes = new boolean[length+1];
		primes[0] = true;
		primes[1] = true;
		
		for(int i=2;i<=Math.sqrt(length);i++) {
			if(primes[i]) {
				continue;
			}
			
			for(int j=i*2;j<=length;j+=i) {
				primes[j] = true;
			}
		}
		
		for(int i : set) {
			if(!primes[i]) {
				answer++;
			}
		}
		
		return answer;		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "17";
		System.out.println("answer : "+solution(s));
		s="011";
		System.out.println("answer : "+solution(s));
	}

}
