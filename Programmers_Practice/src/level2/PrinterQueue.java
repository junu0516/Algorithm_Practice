package level2;

import java.util.LinkedList;
import java.util.Queue;
/*
 * 
 * ���� ����
�Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. �̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.

1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
3. �׷��� ������ J�� �μ��մϴ�.
���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.

���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.

���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� ���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * */
class PrinterQueue {
    public int solution(int[] priorities, int location) {
        Queue<int[]> toPrint = new LinkedList<int[]>();
        for(int i=0;i<priorities.length;i++){
            int[] doc = new int[2];
            doc[0] = i;
            doc[1] = priorities[i];
            toPrint.add(doc);
        }
        
        int count = 0;
        while(!toPrint.isEmpty()){
            int[] curr = toPrint.poll();
            boolean print = true;
            
            for(int[] doc : toPrint){
                if(doc[1]>curr[1]){
                    print = false;
                }   
            }
            
            if(print){
                count++;
                if(curr[0] == location ){
                    break;
                }
            }else{
                toPrint.add(curr);
            }
        }
        
        
        int answer = count;
        return answer;
    }
}