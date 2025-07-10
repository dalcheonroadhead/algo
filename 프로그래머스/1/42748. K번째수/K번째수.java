import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int [commands.length];
        for(int i = 0; i < commands.length; i++){
            int [] sub = subOfRange(array, commands[i][0]-1, commands[i][1]-1);
            Arrays.sort(sub);
            answer[i] = sub[commands[i][2] - 1];
        }
        return answer;
    }
    
    public int [] subOfRange (int [] arr, int s, int e) {
        int [] answer = new int [e-s+1];
        
        for(int i = s; i <=e; i++){
            answer[i-s] = arr[i];
        }
        
        return answer;
    }
}