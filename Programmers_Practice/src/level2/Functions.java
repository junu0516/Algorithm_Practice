package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Functions {
	public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //�����ð� ���
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
        
        //�ϴ� �� ó�� ��� �Ϸ�Ǿ��ٰ� �����ϰ�, ť���� �ϳ� ���� ����(count�� 1�� ����)
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
