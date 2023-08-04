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
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Integer> accSums = new ArrayList<>();
	static int N,M,sum = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		  // 자연수 N까지 
		  N = Integer.parseInt(st.nextToken());
		
		  // i와 j 쌍의 갯수
		  M = Integer.parseInt(st.nextToken());
		 
		  st = new StringTokenizer(br.readLine());
		  for(int i = 0; i < N; i++) {
			  list.add(Integer.parseInt(st.nextToken()));
		  }
		  
		  acc(0);
		  
		  for(int i = 0; i< M; i++) {
			  st = new StringTokenizer(br.readLine());  
			  int base = Integer.parseInt(st.nextToken())-1;
			  int deepth = Integer.parseInt(st.nextToken())-1;
			  
			  if(base == deepth) {
				 System.out.println(list.get(base));
			  }else if(base >0) {
				  System.out.println(accSums.get(deepth) - accSums.get(base-1));
			  }else if(base <=0) {
				  System.out.println(accSums.get(deepth));
			  }
		  }
		  
		  
		  
	}
	
	public static void acc(int deepth) {
		if(deepth == N) {
			return;
		}
		
		
		sum +=list.get(deepth);
		accSums.add(deepth, sum);
		acc(deepth+1);
		
	}
	
}