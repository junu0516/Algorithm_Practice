package baekjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Boj_10816 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //카드의 개수
		
		//카드에 적혀있는 수 입력
		HashMap<Integer,Integer> cards = new HashMap<>(); // key : 적혀있는 숫자, value : 숫자의 개수
		for(int i=0;i<n;i++) {
			int key = sc.nextInt();
			if(cards.containsKey(key)) {
				cards.put(key, cards.get(key)+1);
			}else {
				cards.put(key, 1);
			}
		}
		
		//key 배열 생성
		int[] keyArr = new int[cards.keySet().size()];
		int index = 0;
		for(int key : cards.keySet()) {
			keyArr[index] = key;
			index++;
		}
		
		Arrays.sort(keyArr); //이분탐색을 위한 오름차순 정렬
		
		//몇 개 가지고 있는 지 구해야 할 수 입력
		int m = sc.nextInt();
		int[] numbers = new int[m];
		for(int i=0;i<m;i++) {
			numbers[i] = sc.nextInt();
		}
		
		//이분탐색을 통해 numbers 배열 내의 각 숫자가 keyArr 배열 내에 존재하는 지 판별
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<numbers.length;i++) {
			
			int curr = numbers[i];
			if(check(keyArr,curr)) {
				sb.append(cards.get(curr)+" ");
			}else {
				sb.append(0+" ");
			}
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean check(int[] keyArr, int curr) {
		
		int high = keyArr.length-1;
		int low = 0;
		int mid = 0;
		
		while(low<=high) {
			mid = (high+low)/2;
			
			if(curr>keyArr[mid]) {
				low = mid+1;
			}else if(curr<keyArr[mid]) {
				high = mid-1;
			}else {
				//수가 존재할 경우 true
				return true;
			}
		}
		//반복문을 빠져나올 경우 수가 존재하지 않는 것이므로 false
		return false;
	}

}
