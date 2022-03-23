package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_�ܾ����� {
	static int N;
	static String[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
					// ���ڿ� ���̰� ���ٸ� ���������� ����
				}
				else {
					return o1.length() - o2.length();
					// �ش� ��ȯ ���� ����� o1�� ū ���� �ȴ�.
				}
			}
		});
		
		System.out.println(arr[0]);
		for (int i = 1; i < N; i++) {
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}

	}

}
