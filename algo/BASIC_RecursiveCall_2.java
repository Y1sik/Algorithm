package algo;

import java.util.ArrayList;
import java.util.Random;

public class BASIC_RecursiveCall_2 {
	static Random random = new Random();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		rand(0, 0, 0);
	}

	static void rand(int sum, int evenCnt, int threeCnt) {
		
		if( sum > 100 ) {
			System.out.println(sum);
			System.out.println(evenCnt);
			System.out.println(threeCnt);
			for (int n : list) {
				System.out.print(n + " ");
			}
			return;
		}
		
		int n = random.nextInt(10);
		list.add(n);
		int even = 0;
		if( n % 2 == 0) even++;
		int three = 0;
		if( n % 3 == 0) three++;
		
		rand(sum + n, evenCnt + even, threeCnt + three);
	}
}
