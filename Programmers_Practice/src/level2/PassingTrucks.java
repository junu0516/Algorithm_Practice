package level2;

import java.util.*;
public class PassingTrucks {
	static class Truck{
        private int weight=0;
        private int time=0;
        
        Truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}
        
        
    }
    
    public static int solution(int bridge, int limit, int[] weights) {
        Queue<Truck> passing = new LinkedList<>();
        Queue<Truck> waiting = new LinkedList<>();
        
        for(int i = 0 ; i < weights.length ; i++){
            waiting.offer(new Truck(weights[i], 0));
        }
        int count = 0;
        int total = 0;
        
        while(!passing.isEmpty() || !waiting.isEmpty()){
            count++;
            
            if(!passing.isEmpty()){
                Truck tr = passing.peek();
                int compare = count - tr.getTime();
                if(compare >= bridge){
                    total -= tr.getWeight();
                    passing.poll();
                }
            }
            
            if(!waiting.isEmpty()){
                if(total + waiting.peek().getWeight() <= limit){
                    Truck tr = waiting.poll();
                    tr.setTime(count);
                    total += tr.getWeight();
                    passing.offer(tr);                    
                }
            }
        }
        return count;
    }			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(2,10,new int[] {7,4,5,6}));
	}

}
