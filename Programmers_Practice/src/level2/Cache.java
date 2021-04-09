package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	/*
	 * DB캐시를 적용할 때, 캐시 크기에 따른 실행시간 측정 프로그램 작성하기
	 * 
	 * 조건)
	 * -- 캐시 크기와 도시이름 배열을 입력값으로 받음
	 * -- 캐시 크기는 정수이며 0이상 30이하의 범위를 가짐
	 * -- 도시 이름은 문자열 배열로, 최대 도시의 수는 100,000개임
	 * -- 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며 대소문자를 구분하지 않는 최대 20자로 이루어짐
	 * 
	 * -- 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용
	 * -- LRU : 가장 오랫동안 참조하지 않은 페이지를 캐시에서 교체
	 * -- cache hit : 실행시간 1 / 이미 캐시에 있던 페이지를 가장 처음으로 가져오는 행위
	 * -- cache miss : 실행시간 5 / 캐시가 가득 차서 페이지를 삭제하고 새로운 페이지를 삽입하거나 자리가 있는 경우 새로운 페이지를 그냥 삽입하는 행위
	 * 
	 * -----> 캐시 사이즈가 0인 경우에는 cache miss가 바로 발생하게 됨
	 * 
	 * */
	
	public static int solution(int cacheSize, String[] cities) {
		
		if(cacheSize == 0) {
			/*
			 * 만일 캐시 사이즈가 0이고, 같은 도시만 여러개 있는 배열인 경우에는
			 * 따로 예외를 처리하지 않을 경우 이상한 값이 나오므로 처음부터 아얘 다시 판별
			 * 
			 * */
			return cities.length*5;
		}
		
		int time=0;
		
		Queue<String> cache = new LinkedList<String>();
		for(String city : cities) {
			
			city = city.toLowerCase();
			
			if(!cache.contains(city)) {
				//캐시에 도시정보가 없는 경우 : cache miss
				
				if(cache.size()<cacheSize) {//캐시 사이즈에 여유가 있는 경우
					cache.add(city);
				}else {//캐시 사이즈에 여유가 없는 경유
					cache.poll(); //제일 오래된 페이지를 삭제함
					cache.add(city);
				}
	
				time += 5;
			}else {
				//이미 캐시에 도시정보가 존재하는 경우 : cache hit
				cache.remove(city);
				cache.add(city);
				time += 1;
			}
			
			
		}
		
		return time;
	}
	
	public static void main(String[] args) {
		
		int cacheSize = 3;
		String[] cities = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize,cities));
		
		cacheSize = 2;
		cities = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(cacheSize,cities));
		
		cacheSize = 0;
		cities = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize,cities));
		
		cacheSize = 5;
		cities = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(cacheSize,cities));
		
		cacheSize = 0;
		cities = new String[] {"Jeju","Jeju","Jeju","Jeju" };
		System.out.println(solution(cacheSize,cities));
	}

}
