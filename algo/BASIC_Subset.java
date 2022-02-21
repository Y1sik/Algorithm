package algo;

import java.util.Arrays;

public class BASIC_Subset {

	static int COUNT = 0;
	static int[] src = {1, 2, 3, 4, 5};
	
	// 以묐났 �닚�뿴 X
	// 以묐났 �뿀�슜 X
	
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subset(0);
		System.out.println(COUNT);
	}
	
	private static void subset(int srcIdx) {
		
		//湲곗� 議곌굔
		if(srcIdx == src.length) {
			// complete code!!
			// 遺�遺� 吏묓빀�씠 �븯�굹 �셿�꽦�맖
			printSubset();
			COUNT++;
			return;
		}
		
		// �꽑�깮
		select[srcIdx] = true;
		subset(srcIdx + 1);
		
		// 鍮꾩꽑�깮
		select[srcIdx] = false;
		subset(srcIdx + 1);
		
		
	}
	static void printSubset() {
		for (int i = 0; i < select.length; i++) {
			if(select[i]) System.out.print(src[i] + " ");
		}
		System.out.println();
	}
}
