package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_톱니바퀴 {
	static LinkedList<Integer>[] gear;
	static int k;
	static int index, dir;
	static int[] isValid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		gear = new LinkedList[4];
		
		for (int i = 0; i < 4; i++) {
			gear[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i].add(str.charAt(j) - '0');
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			index = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());
			isValid = new int[4]; // 회전하는 방향 저장
			check(index, dir); // 회전해야하는 톱니바퀴 체크
			rotate(isValid); // 톱니바퀴 회전
		}
		int result = calc();
		System.out.println(result);

	}
	private static int calc() {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i].get(0) == 1) { // 12시 방향 톱니가 n일 경우
				result += Math.pow(2, i); // 1번 톱니 바퀴일 경우 2^0, 2번 2^1, 3번 2^2, 4번 2^3
			}
		}
		return result;
	}
	private static void rotate(int[] isValid) {
		for (int i = 0; i < 4; i++) {
			if(isValid[i] == 1) { // 회전 방향이 시계방향일 경우
				int temp = gear[i].pollLast(); // list의 마지막 원소 가져오면서 삭제
				gear[i].addFirst(temp); // list의 첫번째 원소로 추가
			}else if(isValid[i] == -1) { // 회전 방향이 반시계방향일 경우
				int temp = gear[i].pollFirst(); // list의 첫번째 원소 가져오면서 삭제
				gear[i].addLast(temp); // list의 마지막 원소로 추가
			}
		}
		
	}
	private static void check(int index, int dir) {
		isValid[index] = dir; 
		
		int prev = index - 1; // 왼쪽 톱니바퀴
		int post = index + 1; // 오른쪽 톱니바퀴
		
		if(prev >= 0 && isValid[prev] == 0) { // 왼쪽 톱니바퀴
			if(gear[prev].get(2) != gear[index].get(6)) { // 왼쪽 2번 톱니와 현재 6번 톱니가 다를 경우 
				check(prev, dir * -1); // 왼쪽 톱니바퀴로 가서 체크
			}
		}
		
		if(post <= 3 && isValid[post] == 0) { // 오른쪽 톱니바퀴
			if(gear[post].get(6) != gear[index].get(2)) { // 오른쪽 6번 톱니와 현재 2번 톱니가 다를 경우
				check(post, dir * -1); // 오른쪽 톱니바퀴로 가서 체크
			}
		}
	}

}
