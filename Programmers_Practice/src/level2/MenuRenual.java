package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MenuRenual {
	
	public static String[] solution(String[] orders, int[] course) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		//각각이 course 길이에 대해, 가능한 모든 조합을 담아줄 map
		HashMap<Integer,ArrayList<String>> map = new HashMap<>();
		//각각의 조합이 총 몇번 등장했는 지 담아줄 map
		HashMap<String,Integer> map2 = new HashMap<>();
		//각각의 course 길이에 대해, 주문횟수의 최댓값들을 담아줄 map
		HashMap<Integer,Integer> map3 = new HashMap<>();
		
		for(String order : orders) {
			int n = order.length();
			for(int r : course) {
				if(n<r) {
					continue;
				}
				
				//map3의 key로 각각의 course 길이와, 초기값 0을 담아줌
				if(!map3.containsKey(r)) {
					map3.put(r, 0);
				}
				
				//nCr이 되는 모든 조합을 도출
				char[] chars = order.toCharArray();
				boolean[] visited = new boolean[chars.length];
				ArrayList<String> combs = new ArrayList<>();
				getCombination(chars,visited,0,n,r,combs,map2);
				
				//r을 Key로 하여, 도출된 모든 조합 combs를 value로  map에 담아줌
				if(!map.containsKey(r)) {
					map.put(r, new ArrayList<String>());
				}
				for(String comb : combs) {
					if(!map.get(r).contains(comb)) {
						map.get(r).add(comb);
					}
					
				}	
			}
		}
		
		
		for(String order : orders) {
			
			for(int key : map.keySet()) {	
				//order의 길이가, course의 값인 key보다 작으면 그냥 pass
				if(key>order.length()) {
					continue;
				}
				
				//모든 조합에 대해, 등장 횟수의 최댓값들을 구해서 map3에 담아줌
				for(String comb : map.get(key)) {
					if(contains(order,comb)) {
						//일단 order 문자열이 comb의 문자들을 모두 포함하면 map2의 value를 +1해줌
						map2.put(comb, map2.get(comb)+1);
						
						//이후 map3에 대해 최댓값일 경우에는 value를 바꿔줌
						if(map3.get(comb.length())<map2.get(comb)) {
							map3.put(comb.length(), map3.get(comb.length())+1);
						}
					}
				}
			}
		}
		
		//map3의 value가 최댓값이면서 2 이상인 모든 조합을 result 리스트에 담아줌
		for(int key : map.keySet()) {
			for(String comb : map.get(key)) {
				if(map3.get(key)<=map2.get(comb) && map3.get(key)>=2) {
					result.add(comb);
				}
			}
		}
		
		//answer 배열에 result 리스트를 배열로 전환 후, 오름차순 정렬하여 리턴
		String[] answer = result.toArray(new String[result.size()]);
		Arrays.sort(answer, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				
				return s1.compareTo(s2);
			}
			
		});
		
		return answer;
	}
	
	public static boolean contains(String order, String comb) {
		
		//order의 메뉴가 comb의 메뉴들을 포함하는 지 판별
		for(int i=0;i<comb.length();i++) {
			String curr = comb.substring(i,i+1);
			if(order.indexOf(curr) <0) {
				return false;
			}
		}
		return true;
	}
	
	/*가능한 모든 조합을 도출(백트래킹)*/
	public static void getCombination(char[] chars, boolean[] visited, int start, int n, int r, ArrayList<String> combs, HashMap<String,Integer> map2) {

		if(r==0) {

			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				if(visited[i] == true) {
					sb.append(chars[i]);
				}
				
			}
			
			//XY, YX와 같은 경우가 나올 수 있기 때문에, 한 번 오름차순으로 모두 정렬 후 다시 문자열로 만들어줘야 함
			char[] combChars = sb.toString().toCharArray();
			Arrays.sort(combChars);
			sb = new StringBuilder();
			for(char c : combChars) {
				sb.append(c);
			}
			String comb = sb.toString();
			
			if((!combs.contains(comb))) {
				combs.add(comb);					
			}
			if(!map2.containsKey(comb)) {
				map2.put(comb, 0);
			}
			
			return;
		}
		
		for(int i=start;i<n;i++) {
			visited[i] = true;
			getCombination(chars,visited,i+1,n,r-1,combs,map2);
			visited[i] = false;
		}
		
	}
	
	public static void main(String[] args) {
		String[] orders = new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = new int[] {2,3,4};
		String[] result = solution(orders,course);
		
		for(String s : result) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println();
		orders = new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		course = new int[] {2,3,5};
		result = solution(orders,course);
		
		for(String s : result) {
			System.out.print(s+" ");
		}
	}
}
