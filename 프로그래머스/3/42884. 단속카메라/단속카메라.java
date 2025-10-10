import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        boolean [] check = new boolean [routes.length];
        Arrays.sort(routes, (arr1, arr2) -> arr1[1] - arr2[1]);
        
        for(int i = 0; i < routes.length; i++){
            if(check[i]) continue;
            check[i] = true;
            int now = routes[i][1];
            for(int j = i+1; j < routes.length; j++){
                if(check[j]) continue;
                else if(routes[j][0] <= now && routes[j][1] >= now) check[j] = true;
            }
            answer ++;
        }
        
        return answer;
    }
}