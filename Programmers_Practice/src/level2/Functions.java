package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Functions {
	public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //남은시간 계산
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<progresses.length;i++){
            int workLeft = 100-progresses[i];
            int check = workLeft % speeds[i];
            if(check==0){
                queue.add(workLeft/speeds[i]);
            }else{
                queue.add(workLeft/speeds[i]+1);
            }
        }
        
        //일단 맨 처음 기능 완료되었다고 가정하고, 큐에서 하나 빼고 시작(count도 1로 시작)
        int count = 1;
        int prev = queue.poll();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr<=prev){
                count++;
            }else{
                list.add(count);
                count = 1;
                prev = curr;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
                
        return answer;
    }
}
