package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_N과M5 {
	static int N;
	static int M;
	static int[] src;
	static int[] tgt;
	static boolean[] select;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N]; // 순열을 만들 숫자 값
		tgt = new int[M]; // 순열의 크기
		select = new boolean[N]; // 순열에 들어갈지 안들어가지 선택
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		
		perm(0);
	}
	private static void perm(int tgtIdx) {
		if(tgtIdx == tgt.length) {
			for (int i = 0; i < tgt.length; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < src.length; i++) {
			if(select[i]) continue;
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
		
	}

}
