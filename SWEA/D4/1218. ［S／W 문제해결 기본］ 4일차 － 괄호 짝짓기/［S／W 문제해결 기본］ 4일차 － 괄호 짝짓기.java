import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


 

public class Solution {
	


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int T = 1; T<= 10; T++) {
			int N = Integer.parseInt(br.readLine());
			String expression = br.readLine();

			
			int result = 0;
			
			// 주어진 괄호 값들에 대해 모든 검사를 한다.
			for(int i = 0 ; i < N; i++) {
				
			// 왼쪽 괄호면 넣는다. 
				char c = expression.charAt(i);
			if(c == '(' || c == '[' ||c == '{') {
				stack.push(c);
			}
			
			// 오른쪽 괄호를 만나면 pop 
			else if(c ==')'||c== ']' || c =='}') {
				char temp = stack.pop();
				
				// pop한 왼쪽 괄호와 현재 c가 들고 있는 오른쪽 괄호가 pair이면 정상작동이므로 loop를 다시 순회 한다. 
				if((c == ')' && temp == '(') || (c == '}' && temp == '{') ||
						(c == ']' && temp == '[')) {
						continue;
					}
				// 예외처리 -> pop한 녀석이랑 한 pair가 아니면 오류이므로 result에 0을 넣고 loop를 탈출한다.
				else {result = 0; break;}
				}
				
			}

			// 예외처리 -> 검사 다 했는데 stack에 값이 남으면 0 출력 -> pair는 다 맞았으나 전체 값 입력 자체가홀수이다. 
			if(!stack.isEmpty() || expression.length()%2 !=0) {
				result = 0;
			}else {
				result = 1;
			}
			System.out.printf("#%d %d\n",T,result);
			stack.clear();
		}

		}

	}