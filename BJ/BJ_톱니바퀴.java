package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_��Ϲ��� {
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
			isValid = new int[4]; // ȸ���ϴ� ���� ����
			check(index, dir); // ȸ���ؾ��ϴ� ��Ϲ��� üũ
			rotate(isValid); // ��Ϲ��� ȸ��
		}
		int result = calc();
		System.out.println(result);

	}
	private static int calc() {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i].get(0) == 1) { // 12�� ���� ��ϰ� n�� ���
				result += Math.pow(2, i); // 1�� ��� ������ ��� 2^0, 2�� 2^1, 3�� 2^2, 4�� 2^3
			}
		}
		return result;
	}
	private static void rotate(int[] isValid) {
		for (int i = 0; i < 4; i++) {
			if(isValid[i] == 1) { // ȸ�� ������ �ð������ ���
				int temp = gear[i].pollLast(); // list�� ������ ���� �������鼭 ����
				gear[i].addFirst(temp); // list�� ù��° ���ҷ� �߰�
			}else if(isValid[i] == -1) { // ȸ�� ������ �ݽð������ ���
				int temp = gear[i].pollFirst(); // list�� ù��° ���� �������鼭 ����
				gear[i].addLast(temp); // list�� ������ ���ҷ� �߰�
			}
		}
		
	}
	private static void check(int index, int dir) {
		isValid[index] = dir; 
		
		int prev = index - 1; // ���� ��Ϲ���
		int post = index + 1; // ������ ��Ϲ���
		
		if(prev >= 0 && isValid[prev] == 0) { // ���� ��Ϲ���
			if(gear[prev].get(2) != gear[index].get(6)) { // ���� 2�� ��Ͽ� ���� 6�� ��ϰ� �ٸ� ��� 
				check(prev, dir * -1); // ���� ��Ϲ����� ���� üũ
			}
		}
		
		if(post <= 3 && isValid[post] == 0) { // ������ ��Ϲ���
			if(gear[post].get(6) != gear[index].get(2)) { // ������ 6�� ��Ͽ� ���� 2�� ��ϰ� �ٸ� ���
				check(post, dir * -1); // ������ ��Ϲ����� ���� üũ
			}
		}
	}

}
