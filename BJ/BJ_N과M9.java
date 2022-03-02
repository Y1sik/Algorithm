package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ_N과M9 {
	static int N, M;
	static int[] src;
	static int[] tgt;
	static boolean[] select;
	static LinkedHashSet<String> result; // 입력 순으로 정렬 됨
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		tgt = new int[M];
		select = new boolean[N];
		result = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		
		perm(0);
		result.forEach(System.out :: println);
	}

	private static void perm(int tgtIdx) {
		if(tgtIdx == tgt.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tgt.length; i++) {
				sb.append(tgt[i]).append(' ');
			}
			result.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < select.length; i++) {
			if(select[i]) continue;
			
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
		
	}

}
