package level2;

public class Triangle {
	
	public static int[] solution(int n) {
		/*
		 * 
		 * n=5�� ��,
		 * �ﰢ���� ����� �Ʒ��� ����..
		 * 1
		 * 2 12
		 * 3 13 11
		 * 4 14 15 10
		 * 5  6  7  8  9
		 * 
		 * �����ϸ�,
		 * (�Ʒ� -> ������ -> �밢�� ��) ������������ �ݺ��ϸ鼭 �����̰� ����
		 * �̵�Ƚ���� �� n���̸� ù �������� n���� ĭ�� �̵��ϸ�, ���� ������ n-1���� ĭ�� �̵�(������ �ٲ� ������ �̵��ϴ� ĭ���� 1���� �پ��)
		 * ���� ������ �迭 �׷����� ���� ���� ������ �׷����� Ž���ϸ鼭 ���ڸ� �ϳ��� �־��ָ� ��
		 * 
		 * */
		int[][] triangle = new int[n][n];
        int y=-1; //0,0���� �����ؾ� �ϱ� ������ y�� �ʱⰪ�� -1�̾�� ��(�ϴ� ������ ��ǥ���� +1�ϰ� �����ϱ� ����)
        int x=0;
        int value = 1;
        
        for(int i=0;i<n;i++){//�� n���� �̵��ϴµ�, �Ʒ� -> ������ -> �밢�� �� �� ������ �������� �������� ��
            //i��° �̵��� ��� �������� �̵��ؾ� �ϴ� �������� �Ǻ� 
        	for(int j=i;j<n;j++){//�̵��ϴ� ĭ���� ������ �ݺ��ɶ����� ���� �پ��
                if(i%3==1){//���������� �� ��
                    x++;
                }else if(i%3==2){//�밢�� ���� �ö� ��
                    x--;
                    y--;
                }else if(i%3==0){//�Ʒ��� ������ ��
                    y++;
                }
                triangle[y][x] = value++;    
            }
        }
        
        int[] answer = new int[(n*(n+1))/2];
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(triangle[i][j]==0){
                    break;
                }
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int[] result = solution(n);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
		
		n=5;
		result = solution(n);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
		
		n=6;
		result = solution(n);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}

}
