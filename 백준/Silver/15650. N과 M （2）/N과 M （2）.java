import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] list;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
			// 자연수가 1부터 ~N 
		  N = Integer.parseInt(st.nextToken());
		  
		  M = Integer.parseInt(st.nextToken());
		 
		  // 조합으로 선택된 값들이 담길 곳, 
		  list = new int[M];
		  Combination(0, 1);
		
	}
	
	public static void Combination(int deepth, int start) {
		if(deepth == M) {
			for(int a : list) {
				System.out.println(a);
			}
			return;
		}
		
		for(int i = start; i <= N ; i ++) {
			list[deepth] = i; 
			Combination(deepth+1, i+1);
		}
		
	}
}