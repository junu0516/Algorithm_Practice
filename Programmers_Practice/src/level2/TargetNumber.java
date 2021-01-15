package level2;

public class TargetNumber {
	
	public static int solution(int[] numbers, int target) {
		//깊이우선 탐색으로 모든 분기를 탐색
		int answer = 0;
		answer += dfs(numbers,1,numbers[0],target); //배열, 인덱스, 누적합, 타겟
		answer += dfs(numbers,1,-numbers[0],target); //음수부터 시작하는 경우 고려
		return answer;
	}
	
	public static int dfs(int[] numbers, int index, int sum, int target) {
		if(index>=numbers.length ) {
			if(target==sum) {
				return 1;
			}
			return 0;
		}
		
		int sum1 = sum + numbers[index];
		int sum2 = sum - numbers[index];
		
		int count = 0;
		count += dfs(numbers,index+1,sum1,target);
		count += dfs(numbers,index+1,sum2,target);
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] {1,1,1,1,1};
		int target = 3;
		int result = solution(numbers,target);
		System.out.println(result);
	}

}
