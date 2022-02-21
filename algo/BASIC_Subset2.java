package algo;

import java.util.Arrays;

public class BASIC_Subset2 {
	
	static int[] src = {1,2,3,4,5};
	static boolean[] select = new boolean[src.length];
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subSet(0);
		System.out.println(cnt);
	}

	private static void subSet(int srcIdx) {
		// TODO Auto-generated method stub
		if(srcIdx == src.length) {
			for (int i = 0; i < select.length; i++) {
				if(select[i]) {
					System.out.print(src[i] + " ");
				}
			}
			System.out.println();
			cnt++;
			return;
		}
		
		select[srcIdx] = true;
		subSet(srcIdx + 1);
		select[srcIdx] = false;
		subSet(srcIdx + 1);
	}

	
	
	
}
