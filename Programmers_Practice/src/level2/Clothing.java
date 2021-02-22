package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Clothing {
	
	public static int solution(String[][] clothes) {
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i=0;i<clothes.length;i++) {
			String key = clothes[i][1];
			if(map.containsKey(key)) {
				map.put(key,map.get(key)+1);
			}else {
				map.put(key,1);
			}
		}
		
		int answer = 1;
		for(int value : map.values()) {
			answer *= value+1;
		}
		
		return answer-1;
	}

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
		System.out.println(solution(clothes));
		
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses","face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes2));
		
	}
}
