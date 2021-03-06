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
		if(tgtIdx == tgt.length) { // 순열의 크기가 됐으면 출력
			for (int i = 0; i < tgt.length; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < src.length; i++) {
			if(select[i]) continue; // select가 true일 때 이미 tgt에 들어가 있다.
			tgt[tgtIdx] = src[i]; // 순열에 들어갈 src값
			select[i] = true; // 순열에 값이 들어갔으니 select는 true
			perm(tgtIdx + 1); // tgt i에 값이 들어갔으니 +1 해준다
			select[i] = false; // 순열에서 값이 이제 빠지게 된다. false
		}
		
	}

}
