package test;

public class QuickSort {
	/*재귀호출로 퀵정렬 연습해보기*/
	
	/*
	 * 
	 * 1. 임의의 원소를 골라 pivot으로 설정
	 * 2. pivot 앞에는 보다 작은 값이, 뒤에는 보다 큰 값이 오도록 둘로 분할
	 * 3. 분할된 두개의 리스트에 대해 다시 1~2의 과정을 반복
	 * 4. 나눈 리스트의 크기가 0이나 1이 될 때까지 1~3을 반복
	 * 
	 * */
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,7,8,5,2,1,9,5,4}; //임의의 정렬 arr을 오름차순으로 정렬한다고 가정
		print(arr);
		System.out.println();
		quickSort(arr,0,arr.length-1); //퀵정렬 실행
		
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left>=right) {
			return;
		}
		
		int pivot = partition(arr,left,right); //피벗값 도출
		
		/*피벗값을 기준으로 배열을 두개로 분할 후 정렬(재귀호출)*/
		quickSort(arr,left,pivot-1); //피벗 왼쪽 배열
		quickSort(arr,pivot,right); //피벗 오른쪽 배열
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left+right)/2];//임의의 중앙값을 partition() 함수에서의 피벗값으로 설정
		System.out.println("pivot : "+pivot);
		while(left<=right) { //서로 교차하지 않는 동안 반복
			//피벗보다 큰 값의 위치를 찾음
			while(arr[left]<pivot) {
				left++; //위치값이 left에 해당하는 숫자가 pivot값보다 작으면 오른쪽으로 한 칸을 이동해서 다시 비교
			}
			//피벗보다 작은 값의 위치를 찾음
			while(arr[right]>pivot) {
				right--; //위치값이 right에 해당하는 숫자가 pivot값보다 크면 왼쪽으로 한 칸을 이동해서 다시 비교
			}
			
			/*
			 * 위의 두 개의 반복문을 빠져나오면,
			 * left값은 pivot보다 큰 값의 위치를 가리키고,
			 * right값은 pivot보다 작은 값의 위치를 가리킴
			 * 
			 * 따라서, (아직 교차하지 않았다면)마지막으로 left와 right의 위치를 바꿔줘야 함
			 * */
			
			if(left<=right) { //left>right면 서로 교차했기 때문에 굳이 바꿀 필요 없음
				swap(arr,left,right);
				//swap()을 실행하고 나면, left에 해당하는 숫자가 다시 피벗보다 작은 값을, right에 해당하는 숫자가 다시 피벗보다 큰 값을 가리킴ㅁ
				//따라서 각각 한 칸씩 다시 이동시켜야 함
				left++;
				right--;
			}
		}
		System.out.println("left : "+left+", right : "+right);
		print(arr);
		System.out.println();
		return left; //여기서의 리턴값이 다음 정렬시 partition() 함수의 기준이 되는 피벗값이 됨 
	}
	
	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
