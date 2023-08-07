import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;


 

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		
		for(int test_case = 0; test_case<10; test_case++) {
			int originLength = Integer.parseInt(br.readLine());
			// 1. ArrayList에 기존 문자열을 집어넣는다. 
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i<originLength; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int edit = Integer.parseInt(br.readLine());
			
			st = new  StringTokenizer(br.readLine(), "I", false);
			
			for(int i = 0 ; i < edit ; i++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken());
				int index = Integer.parseInt(st2.nextToken());
				int count = Integer.parseInt(st2.nextToken());
				
				for(int j = 0; j <count; j++) {
					list.add(index++, Integer.parseInt(st2.nextToken()));
				}
			}
			
			System.out.printf("#%d ",test_case+1);
			for(int i = 0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			
			list.clear();
			
			
		}
		
	}
}