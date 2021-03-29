package test;

public class MergeSort {
	/*병합정렬 구현하기*/
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{6,5,3,1,8,7,2,4};
		
		//병합정렬
		int[] temp = new int[arr.length];
		mergeSort(arr,temp,0,arr.length-1);
        
        //정렬 결과 확인
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
	}
	
	public static void mergeSort(int[] arr, int[] temp, int start, int end) {
		
		//시작 인덱스(start) 값이 마지막 인덱스(end) 값보다 작은 동안에만 재귀호출을 진행
		if(start<end) {
			int mid = (start+end)/2;
			
			//가운데 인덱스(mid)를 기준으로 둘로 나눠줌
			mergeSort(arr,temp,start,mid);
			mergeSort(arr,temp,mid+1,end);
			
			//모두 나누고 나면, 나뉜 배열을 다시 병합해줌
			merge(arr,temp,start,mid,end);
		}
		
	}
	
	public static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		
		//임시 배열에 배열 값을 넣어줌
		for(int i=start;i<=end;i++) {
			temp[i] = arr[i];
		}
		
		//나뉜 두 배열의 값을 처음부터 서로 비교해줌
		
		int front = start; //앞쪽 배열의 비교값
		int back = mid+1; //뒤쪽 배열의 비교값
		int index = start; //비교 후 선택된 값을, 배열의 어느 위치에 넣어줄 지를 결정할 인덱스값
		
		while(front<=mid && back<=end) { //두 배열의 처음부터 끝까지 비교를 진행
			
			if(temp[front]<=temp[back]) { //앞쪽 배열의 값이 더 작은 경우
				arr[index] = temp[front];
				front++;
			}else { //뒤쪽 배열의 값이 더 작은 경우
				arr[index] = temp[back];
				back++;
			}
			
			index++;
		}
		
		//앞쪽 배열과 뒤쪽 배열의 길이기 각각 다를 수 있기 때문에, 반복문을 빠져나와도 비교가 진행되지 않은 데이터가 남아있을 수 있음
		//단, 뒤쪽 배열의 경우 사실상 이미 자리를 잡고 있기 때문에 여기서는 앞쪽 배열만 고려해줘도 됨
        for(int i=0;i<=mid-front;i++){
            arr[index+i] = temp[front+i];
        }

	}

}
