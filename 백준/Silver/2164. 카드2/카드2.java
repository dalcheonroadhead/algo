import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        // 1. 카드 수 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        // 1-1. 1~N까지 차례대로 카드 덱으로 구성 
        for(int i = 1; i <= N; i++) {
        	dq.addLast(i);
        }
        
        
        // 2. while loop 돌리기 
        while(true) {
        	
        	//** 탈출 조건 q안이 1개 남았을 경우**
        	if(dq.size() == 1) break;
        	
        	// 3. 맨 앞의 숫자는 버리기
        	dq.pollFirst();
            // 4. 그 다음으로 맨 앞 숫자가 되는 녀석은 Deck의 맨 밑으로 보내기 
            dq.addLast(dq.poll());
        	// 5. 이것을 반복 	
        }
        
        System.out.println(dq.pollFirst());
        
        
    }   
}