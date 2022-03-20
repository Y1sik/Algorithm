package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sk_test {
	static String[] arr;
	static String[] process;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new String[N];
		process = new String[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken();
		}
		
		for (int i = 0; i < M; i++) {
			process[i] = br.readLine();
		}
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(process));
		
		Processing();
	}
	private static void Processing() {
		
		
	}

}
