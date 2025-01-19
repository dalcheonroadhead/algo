import java.util.*;


class Solution {
    
    public int solution(int[][] targets) {
        int ans = 0;
        Arrays.sort(targets, (o1,o2) -> {
            if(o1[1]==o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        for(int i = 0; i < targets.length; i++){
            int shot = targets[i][1];
            while(i < targets.length - 1 && shot > targets[i+1][0]) i++;
            ans++;
        }
        return ans;
    }
}