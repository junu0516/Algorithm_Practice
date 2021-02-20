package level2;

import java.util.*;

public class RankingSearch {
	
	//* [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?
	//이중반복문 사용시 O(N^2)으로 인해 시간초과 발생
	//어떻게 하면 더 효율적으로 짤 것인가 ...
	
	public static int[] solution(String[] info, String[] query) {
		
		int[] answer = new int[query.length];
	//	HashMap<Integer,ArrayList<String>> map = getMap(info);
		HashMap<String,ArrayList<Integer>> map2 = getMap2(info);
		
	//	int[] keys = new int[map.keySet().size()];
	//	int idx=0;
	//	for(int i : map.keySet()) {
	//		keys[idx] = i;
	//		idx++;
	//	}
		
	//	Arrays.sort(keys);
		
		for(int i=0;i<query.length;i++) {
			
			int count = 0;
			String[] arr = query[i].split(" ");
			String con = arr[0]+" and "+arr[2]+" and "+arr[4]+" and "+arr[6];
			int score = Integer.parseInt(arr[7]);

			System.out.println(i+1+"번째 조건 : "+con);
			System.out.println("기준 점수 : "+score);
			
			ArrayList<Integer> scores = map2.get(con);
			if(scores ==null) {
				answer[i] = count;
				System.out.println("scores : "+scores);
				System.out.println();
				continue;
			}
			Collections.sort(scores);
			System.out.println("scores : "+scores);
			
			int bound = getLowerBound(scores,score);
			System.out.println("bound : "+bound);
			System.out.println();
			count = scores.size()-bound;
			
			answer[i] = count;
			
		}
		
		return answer;
	}
	
	private static int getLowerBound(ArrayList<Integer> scores, int score) {
		
		int begin = 0;
		int end = scores.size();
		
		while(begin<end) {
			int mid = (begin+end)/2;
			
			if(scores.get(mid)>=score) {
				end = mid;
			}else {
				begin = mid+1;
			}
		}
		
		return end;
	}
	
	public static HashMap<String,ArrayList<Integer>> getMap2(String[] info){
		
		HashMap<String,ArrayList<Integer>> map = new HashMap<>();
		for(String str : info) {
			String[] arr = str.split(" ");
			int score = Integer.parseInt(arr[4]);
			
			
			ArrayList<String> examples = new ArrayList<>();
			
			examples.add(arr[0]+" and "+arr[1]+" and "+arr[2]+" and "+arr[3]);

			examples.add("-"+" and "+arr[1]+" and "+arr[2]+" and "+arr[3]);
			examples.add(arr[0]+" and "+"-"+" and "+arr[2]+" and "+arr[3]);
			examples.add(arr[0]+" and "+arr[1]+" and "+"-"+" and "+arr[3]);
			examples.add(arr[0]+" and "+arr[1]+" and "+arr[2]+" and "+"-");

			examples.add("-"+" and "+"-"+" and "+arr[2]+" and "+arr[3]);
			examples.add("-"+" and "+arr[1]+" and "+"-"+" and "+arr[3]);
			examples.add("-"+" and "+arr[1]+" and "+arr[2]+" and "+"-");
			examples.add(arr[0]+" and "+"-"+" and "+"-"+" and "+arr[3]);
			examples.add(arr[0]+" and "+"-"+" and "+arr[2]+" and "+"-");
			examples.add(arr[0]+" and "+arr[1]+" and "+"-"+" and "+"-");
			
			examples.add("-"+" and "+"-"+" and "+"-"+" and "+arr[3]);
			examples.add("-"+" and "+"-"+" and "+arr[2]+" and "+"-");
			examples.add("-"+" and "+arr[1]+" and "+"-"+" and "+"-");
			examples.add(arr[0]+" and "+"-"+" and "+"-"+" and "+"-");

			examples.add("-"+" and "+"-"+" and "+"-"+" and "+"-");
			
			for(String example : examples) {
				if(map.containsKey(example)) {
					
					ArrayList<Integer> list = map.get(example);
					list.add(score);
					map.put(example, list);
					
				}else {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(score);
					map.put(example, list);
				}
			}
		}
		
		return map;
	}
/*
	public static HashMap<Integer,ArrayList<String>> getMap(String[] info) {
		HashMap<Integer,ArrayList<String>> map = new HashMap<>();
		
		for(String str : info) {
			String[] arr = str.split(" ");
			int score = Integer.parseInt(arr[4]);
			ArrayList<String> examples = new ArrayList<>();
			
			examples.add(arr[0]+" and "+arr[1]+" and "+arr[2]+" and "+arr[3]+" "+arr[4]);

			examples.add("-"+" and "+arr[1]+" and "+arr[2]+" and "+arr[3]+" "+arr[4]);
			examples.add(arr[0]+" and "+"-"+" and "+arr[2]+" and "+arr[3]+" "+arr[4]);
			examples.add(arr[0]+" and "+arr[1]+" and "+"-"+" and "+arr[3]+" "+arr[4]);
			examples.add(arr[0]+" and "+arr[1]+" and "+arr[2]+" and "+"-"+" "+arr[4]);

			examples.add("-"+" and "+"-"+" and "+arr[2]+" and "+arr[3]+" "+arr[4]);
			examples.add("-"+" and "+arr[1]+" and "+"-"+" and "+arr[3]+" "+arr[4]);
			examples.add("-"+" and "+arr[1]+" and "+arr[2]+" and "+"-"+" "+arr[4]);
			examples.add(arr[0]+" and "+"-"+" and "+"-"+" and "+arr[3]+" "+arr[4]);
			examples.add(arr[0]+" and "+"-"+" and "+arr[2]+" and "+"-"+" "+arr[4]);
			examples.add(arr[0]+" and "+arr[1]+" and "+"-"+" and "+"-"+" "+arr[4]);
			
			examples.add("-"+" and "+"-"+" and "+"-"+" and "+arr[3]+" "+arr[4]);
			examples.add("-"+" and "+"-"+" and "+arr[2]+" and "+"-"+" "+arr[4]);
			examples.add("-"+" and "+arr[1]+" and "+"-"+" and "+"-"+" "+arr[4]);
			examples.add(arr[0]+" and "+"-"+" and "+"-"+" and "+"-"+" "+arr[4]);

			examples.add("-"+" and "+"-"+" and "+"-"+" and "+"-"+" "+arr[4]);
			
			if(map.containsKey(score)) {
				ArrayList<String> list = map.get(score);
				list.addAll(examples);
				map.put(score, list);
			}else {
				map.put(score, examples);
			}
		}
		
		
		return map;
	}
*/
	public static void main(String[] args) {
		
		String[] info = new String[] {"java backend junior pizza 20","java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = new String[] {"java and frontend and senior and pizza 100","java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		for(int i : solution(info,query)) {
			System.out.print(i+" ");
		}
		
	}

}
