package level2;

import java.util.*;
public class PassingTrucks {
	static class Truck{
		 int weight;
	        int time;
	        Truck(int weight, int time){
	            this.weight = weight; //Ʈ���� ����
	            this.time = time; //Ʈ���� �ٸ��� ������ �ð�
	        }        
    }
    
	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int count = 0; //��� Ʈ���� �ٸ��� �ǳ� �ð� ī��Ʈ
	        Queue<Truck> passing = new LinkedList<Truck>(); //�ٸ��� �ǳʴ� ���� Ʈ������ ����
	        Queue<Truck> waiting = new LinkedList<Truck>(); //������� Ʈ������ ����
	        
	        for(int i=0;i<truck_weights.length;i++){
	            waiting.add(new Truck(truck_weights[i],0)); //������� Ʈ������ �ٸ��� ������ �ð��� ��� 0���� �ʱ�ȭ
	        }
	        
	        int total = 0; //���� �ٸ� ���� �ִ� Ʈ������ ������ ��
	        while(!passing.isEmpty() || !waiting.isEmpty()){
	            count++; //�� �������� �ð��� 1�ʾ� �귶�ٰ� ����
	            
	            if(!passing.isEmpty()){
	                Truck truck = passing.peek(); //�ٸ����� �ִ� Ʈ���� ��, ���ο� �ִ� ���� ��ȸ
	                int compare = count - truck.time;//���� �帥 �ð����� Ʈ���� �ٸ��� ���� �ð��� �� ��
	                if(compare>=bridge_length){//�� ���� �ٸ��� ����(�ٸ��� �ǳʴ� �� ������ �ʿ��� �ð�)���� ũ��, �̹� �ٸ��� �ǳ� ������ ����
	                    total -= truck.weight; //�ٸ��� Ʈ������ ���� ���� ����
	                    passing.poll();
	                }
	            }
	            
	            if(!waiting.isEmpty()){
	                Truck truck = waiting.peek();
	                if(total+truck.weight<=weight){//�ٸ��� �ߵ� �� �ִ� ���� ������ �ʰ����� ������ �ٸ����� Ʈ���� �ø�
	                    truck = waiting.poll();
	                    total += truck.weight;
	                    truck.time = count; //Ʈ���� �ٸ��� ������ �ð� ����
	                    passing.offer(truck); //�ٸ����� Ʈ���� �ø�
	                }
	            }
	            
	        }
	        
	        return count;
	    }		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�׽�Ʈ ���̽�
		System.out.println(solution(2,10,new int[] {7,4,5,6}));
		System.out.println(solution(100,100,new int[] {10}));
	}

}
