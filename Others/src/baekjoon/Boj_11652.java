package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class Boj_11652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Long,Long> map = new HashMap<>();
		
		long maxValue=Long.MIN_VALUE;
		long result=0;
		for(int i=0;i<n;i++) {
			long key = sc.nextLong();
			
			if(map.keySet().contains(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, (long)1);
			}
	
			
			long currValue = map.get(key);
			if(currValue>maxValue) {
				result = key;
				maxValue = currValue;
			}else if(currValue==maxValue) {
				if(key<result) {
					result = key;
				}
			}else {
				continue;
			}
		}
		
		System.out.println(result);
	}

}
