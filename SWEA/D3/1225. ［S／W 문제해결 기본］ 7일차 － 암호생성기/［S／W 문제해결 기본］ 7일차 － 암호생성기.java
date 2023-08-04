import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;


 

public class Solution {
	


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int T = 1; T<= 10; T++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());

			//Dequeue로 일련의 값을 받는다. 
				for(int i = 0; i <8; i++) {
					dq.addLast(Integer.parseInt(st.nextToken()));
				}
				// while 문으로 -1 ~-5까지를 반복
				
				// -1~-5 왔다갔다할 감소 수
				int minus = 1;
				while(true) {
					
					// 머리에서 값을 하나 뺸다.
					int num = dq.pollFirst();
					
					// 만약 숫자 - 감소수가 0보다 크면 뺸 값을 다시 꼬리에 집어넣는다.
					if(num - minus >0) {
						dq.addLast(num -minus);
					}
					
					// 만약 숫자 - 감소수가 0보다 작으면 꼬리에 0을 넣고 탈출
					else {
						dq.addLast(0);
						break;
					}
					
					// 감소수는 5가 되면 다시1로 바꾸기
					if(minus == 5) {
						minus = 1;
					}else {
						minus++;
					}
					
				}
				
				System.out.printf("#%d ", T);
				for(int a: dq) {
					System.out.print(a+" ");
				}
				System.out.println();
			
			dq.clear();
		}

	}
}