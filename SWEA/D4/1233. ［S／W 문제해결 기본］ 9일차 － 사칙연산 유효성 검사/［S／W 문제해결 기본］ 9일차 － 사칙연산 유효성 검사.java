import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;


 

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		for(int T = 1; T <=10; T++) {
			char [] values = new char [200];
			int N = Integer.parseInt(br.readLine());
			
			// 유효성 여부를 담는 녀석 
			int valid = 1;
			
			
			// 노드 집어넣기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				values[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}
			
			// 포화 완전 이진 트리가 아니면 계산할 필요 없이 무효한 연산식. 박수는 한 손으로 칠 수 없음
			if(N%2 == 0) {
				valid = 0;
				System.out.printf("#%d %d\n",T, valid);
				continue;
			}
			
			// leaf 노드가 숫자가 아닌 경우 -> 무효
			loopout:
			for(int i = N/2+1; i<=N; i++) {
				switch (values[i]) {
				case'+':
				case'-':
				case'/':
				case'*':
					valid = 0;
					System.out.printf("#%d %d\n",T, valid);
					break loopout;
				}
			}
			
			if(valid == 0) continue;
			
			// leaf 노드/2 한 index의 노드가 사칙 연산자 중 하나가 아닌 경우 -> 무효
			for(int i = 1; i <=N/2; i++) {
				if(values[i] != '+' && values[i] != '-' && values[i] != '/' && values[i] != '*' ) {
					valid = 0;
					System.out.printf("#%d %d\n",T, valid);
					break;
				}
			}
			
			if(valid == 0) continue;
			
			// 이거 다 통과하면 유효성  有
			System.out.printf("#%d %d\n",T, valid);
			
		}			
	}
}