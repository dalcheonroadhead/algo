import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        combination(1,0,n,new int [5], q, ans);
        return answer;
    }
    
    public void combination (int start, int cnt, int n, int [] guess, int [][] q, int [] ans) {
        if(cnt == 5) {
            HashSet <Integer> set = new HashSet<>();
            for(int i = 0; i < 5; i++){
                set.add(guess[i]);
            }
            isPossible(q, ans, set);
            return;
        }
        
        for(int i = start; i <= n; i ++) {
            guess[cnt] = i;
            combination(i+1, cnt+1, n, guess, q, ans);
        }
    }
    
    public void isPossible(int [][]q, int [] ans, HashSet<Integer> set) {
        for(int i = 0; i < q.length; i ++) {
            int sum = 0;
            for(int j = 0; j < 5; j++){
                if(set.contains(q[i][j])) sum++;
            }
            if(sum != ans[i]) return;
        }
        answer ++;
        return;
    }
}