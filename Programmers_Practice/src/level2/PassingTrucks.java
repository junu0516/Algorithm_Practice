package level2;

import java.util.*;
public class PassingTrucks {
	static class Truck{
		 int weight;
	        int time;
	        Truck(int weight, int time){
	            this.weight = weight; //트럭의 무게
	            this.time = time; //트럭이 다리에 진입한 시간
	        }        
    }
    
	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int count = 0; //모든 트럭이 다리를 건넌 시간 카운트
	        Queue<Truck> passing = new LinkedList<Truck>(); //다리를 건너는 중인 트럭들의 모음
	        Queue<Truck> waiting = new LinkedList<Truck>(); //대기중인 트럭들의 모음
	        
	        for(int i=0;i<truck_weights.length;i++){
	            waiting.add(new Truck(truck_weights[i],0)); //대기중인 트럭들이 다리에 진입한 시간은 모두 0으로 초기화
	        }
	        
	        int total = 0; //현재 다리 위에 있는 트럭들의 무게의 합
	        while(!passing.isEmpty() || !waiting.isEmpty()){
	            count++; //매 루프마다 시간이 1초씩 흘렀다고 가정
	            
	            if(!passing.isEmpty()){
	                Truck truck = passing.peek(); //다리위에 있는 트럭들 중, 선두에 있는 것을 조회
	                int compare = count - truck.time;//현재 흐른 시간에서 트럭이 다리를 지난 시간을 뺀 값
	                if(compare>=bridge_length){//뺀 값이 다리의 길이(다리를 건너는 데 완전히 필요한 시간)보다 크면, 이미 다리를 건넌 것으로 간주
	                    total -= truck.weight; //다리위 트럭들의 무게 총합 감소
	                    passing.poll();
	                }
	            }
	            
	            if(!waiting.isEmpty()){
	                Truck truck = waiting.peek();
	                if(total+truck.weight<=weight){//다리가 견딜 수 있는 무게 범위를 초과하지 않으면 다리위에 트럭을 올림
	                    truck = waiting.poll();
	                    total += truck.weight;
	                    truck.time = count; //트럭이 다리에 진입한 시간 세팅
	                    passing.offer(truck); //다리위에 트럭을 올림
	                }
	            }
	            
	        }
	        
	        return count;
	    }		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//테스트 케이스
		System.out.println(solution(2,10,new int[] {7,4,5,6}));
		System.out.println(solution(100,100,new int[] {10}));
	}

}
