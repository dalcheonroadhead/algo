import java.util.*;

public class Solution {
    
    public int[] solution(int []arr) {
        int iter = 0;
        int [] stack = new int [arr.length];
        Arrays.fill(stack, -1);
        
        for(int i = 0; i < arr.length; i++){
            if(i == 0) {
                stack[iter] = arr[i];
                continue;
            }
            if(stack[iter] == arr[i]) continue;
            stack[++iter] = arr[i];
        }
        
        int [] answer = new int [iter+1];
        for(int i = 0; i <= iter; i++){
            answer[i] = stack[i];
        }
        return answer;
    } 
}