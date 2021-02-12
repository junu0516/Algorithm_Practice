package level2;

public class MakingBiggestNumber {
	/*
	 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자 구하기
	 * 예를 들어 1924, 2인 경우
	 * 19 12 13 92 94 24 이렇게 수를 만들 수 있으며 이 중 94가 제일 큰 숫자임
	 * (91, 49 이런식으로는 만들 수 없음)
	 * */
	
	public static String solution(String number, int k) {
		int n = number.length()-k;
		Integer[] arr = new Integer[number.length()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(number.substring(i,i+1));
		}
		
		int count = n;
		int index = 0;
		int max = 0;
		StringBuilder sb = new StringBuilder();

		while(count>0) {
		
			for(int i=index;i<number.length();i++) {
				int curr = arr[i];
				
				if(i+count>number.length()) {
					break;
				}
				
				if(curr>max) {
					max = curr;
					index = i+1;
				}
			}
			
			sb.append(max);
			max=0;
			count--;
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		System.out.println(solution(number,k));
		
		number = "4177252841";
		k = 4;
		System.out.println(solution(number,k));
	}
}
