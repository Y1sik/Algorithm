package algo;

import java.util.Arrays;

public class BASIC_Perm2 {
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3];
	static boolean[] select = new boolean[src.length];
	static int cnt = 0;
	public static void main(String[] args) {
		perm(0);
		System.out.println(cnt);
	}
	private static void perm(int tgtIdx) {
		// TODO Auto-generated method stub
		if(tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			cnt++;
			return;
		}
		for (int i = 0; i < select.length; i++) {
			if(select[i]) continue;
			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx+1);
			select[i] = false;
		}
	}
	
	
}
