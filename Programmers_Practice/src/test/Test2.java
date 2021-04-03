package test;

import java.util.*;

public class Test2 {
	
	/*
	 * 문제:
	 * 
	 * 다단계 구조로 판매 수익의 10%를 추천인에게 넘기는 구조이다.
	 * 
	 * 예를 들어 판매원 A를 판매원 B가 추천했다고 하면,
	 * A가 1200원을 벌었을 때 A는 1080원을 가지고 120원을 B에게 넘긴다.
	 * 이후, B는 120원의 90%만을 가지고 남은 10%를 B의 추천인에게 다시 넘기는 구조이다.
	 * 
	 * 이런식으로 추천인이 없는 경우에는 center.. 즉 회사로 남은 10%를 넘기면 된다.
	 * 
	 * 
	 * */
	
	static HashMap<String, String> map; //판매자, 추천인
	static HashMap<String, Integer> income; //판매자, 벌어들인 수익
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		
		
		map = new HashMap<>();
		income = new HashMap<>();
		for(int i=0;i<enroll.length;i++) {
			
			if(referral[i].equals("-")) {
				map.put(enroll[i],"center");
			}else {
				map.put(enroll[i],referral[i]);
			}
			
			income.put(enroll[i], 0);
		}
		
		
		for(int i=0;i<seller.length;i++) {
			String currSeller = seller[i];
			int revenue = amount[i]*100;
			
			System.out.println("판매원 : "+currSeller+", "+revenue);

			toss(currSeller,revenue,income);

			System.out.println(income);
			System.out.println();
		}
		
		int[] result = new int[enroll.length];
		for(int i=0;i<enroll.length;i++) {
			result[i] = income.get(enroll[i]);
		}
		
		return result;
	}
	
	public static void toss(String seller, int revenue, HashMap<String, Integer> income) {
		
		System.out.println("현재 수익원 : "+seller+", "+revenue);
	
		if(!income.containsKey(seller)) {
			income.put(seller, 0);
		}
		
		//90% 이익 누적
		if(!seller.equals("center")) {
			income.put(seller, income.get(seller) + (int)(revenue*0.9));			
		}else {
			income.put(seller, income.get(seller) + revenue);
		}
		
		//다음 추천인으로 재귀탐색(남은 10% 수익을 추천인에게 넘겨줘야 함)
		if(!seller.equals("center")) {
			toss(map.get(seller),(int)(revenue*0.1),income);					
		}
	}
	
	
	public static void main(String[] args) {
		
		String[] enroll = new String[] {"john","mary","edward","sam","emily","jaimie","tod","young"};
		String[] referral = new String[] {"-","-","mary","edward","mary","mary","jaimie","edward"};
		String[] seller = new String[] {"young","john","tod","emily","mary"};
		int[] amount = new int[] {12,4,2,5,10};
		
		int[] result = solution(enroll,referral,seller,amount);
		for(int i : result) {
			System.out.print(i+" ");
		}

	}

}
