package baekjoon;

import java.util.Scanner;

public class Boj_10824 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] numbers = input.split(" ");
		long number1 = Long.parseLong(numbers[0]+numbers[1]);
		long number2 = Long.parseLong(numbers[2]+numbers[3]);
		
		long result = number1 + number2;
		System.out.println(result);
	}

}
