package level2;

import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue {
    public static int solution(int[] priorities, int location) {
    	//priorities[location]에 해당하는 요소가 큐에서 몇번째로 poll되는 지를 구하자
        int answer = 0;
        Queue<int[]> toPrint = new LinkedList<int[]>(); //문서번호, 중요도
        
        for(int i=0;i<priorities.length;i++){
            int[] doc = new int[2];
            doc[0] = i; //문서번호
            doc[1] = priorities[i]; //중요도
            toPrint.add(doc);
        }
        
        while(!toPrint.isEmpty()){
            int[] curr = toPrint.poll(); //일단 대기리스트에서 빼고 시작
            boolean print = true;
            
            for(int[] doc : toPrint){ //해당 문서의 중요도가 제일 높은지를 판별
                if(doc[1]>curr[1]){
                    print = false; //중요도가 낮은 문서면 print = false로 변경
                }
            }
            
            if(print){//프린트 가능한 상태인 경우
                answer++;
                if(curr[0]==location){ //찾고자하는 문서번호(location)와 일치하면
                    break;
                }
            }else{//프린터할 수 없는 문서면 다시 대기리스트의 맨 끝에 넣어줌
                toPrint.add(curr);
            }
        }        
       return answer;
    }
    
    public static void main(String[] args) {
    	int[] priorities = new int[] {2,1,3,2};
    	int location = 2;
    	int result = solution(priorities,location);
    	System.out.println(result);
    	
    	priorities = new int[] {1,1,9,1,1,1};
    	location = 0;
    	result = solution(priorities,location);
    	System.out.println(result);
    }
}