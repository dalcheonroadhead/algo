import java.util.*;
import java.io.*; 


class Solution {
    public String solution(int n) {

        Stack<Integer> stack = new Stack<>();

        // 3보다 작은 값이 될 때까지 나눈다.
        while(n != 0){
            int temp = n%3;

            if(temp == 0){
                stack.push(4);
                n = n/3 - 1;
            }else{
                stack.push(temp);
                n = n/3;
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = stack.size();
        for(int i = 0; i < x; i ++){
            sb.append(stack.pop());
        }

        // list를 역순 정렬하면, 3진법으로 변환한값

        String answer = String.valueOf(sb);
        return answer;
    }
}