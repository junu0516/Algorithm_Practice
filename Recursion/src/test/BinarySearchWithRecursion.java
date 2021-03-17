package test;

public class BinarySearchWithRecursion {
	//재귀호출을 통해 이진탐색 연습해보기
	//재귀를 통한 분할정복 알고리즘을 구현할 때, 이진탐색 역시 분할정복을 적용한 것을 이해할 수 있음
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9}; //오름차순으로 정렬된 임의의 정수 배열을 선언
		
		int x = 8; //여기서는 8이 배열의 몇 번째 인덱스에 위치하는 지를 찾는 문제를 가정
		System.out.println("찾고자 하는 값 : "+x);
		int result = binarySearch(arr,0,arr.length-1,x);
		
		System.out.println(result);
	}
	
	public static int binarySearch(int[] arr, int left, int right, int x) {
		if(left>right) {
			System.out.println("해당 값을 찾을 수 없음");
			return -1;
		}
		
		int mid = (left+right)/2;
		System.out.println("mid : "+mid+", arr[mid] : "+arr[mid]);
		
	
		if(arr[mid]<x) {
			System.out.println("현재 중간값이 너무 작아서 오른쪽 배열을 탐색");
			return binarySearch(arr, mid+1,right,x);
		}else if(arr[mid]>x) {
			System.out.println("현재 중간값이 너무 커서 왼쪽 배열을 탐색");
			return binarySearch(arr,left,mid-1,x);
		}else {
			System.out.println(mid+"번째 위치에서 값을 발견");
			return mid;
		}
		
	}

}
