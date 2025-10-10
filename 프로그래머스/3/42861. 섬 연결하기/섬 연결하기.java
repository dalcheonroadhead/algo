import java.util.*;

class Solution {
    static int [] parents = new int [101];
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        for(int i = 0; i < 101; i++){
            parents[i] = i;
        }
        Arrays.sort(costs, (arr1, arr2) -> arr1[2] - arr2[2]);
        
        for(int i = 0; i < costs.length; i++){
            int start = costs[i][0];
            int end = costs[i][1];
            int v = costs[i][2];
            
            int ancestorA = find(start);
            int ancestorB = find(end);
            
            if(ancestorA == ancestorB) continue;
            union(start, end);
            answer += v;
        }
        
        return answer;
    }
    
    
    public void union (int a, int b){
        int ancestorA = find(a);
        int ancestorB = find(b);
        
        if(ancestorA < ancestorB){
            parents[ancestorB] = ancestorA;
        }else parents[ancestorA] = ancestorB;
    }
    
    public int find(int now) {
        if(parents[now] == now) return now;
        return parents[now] = find(parents[now]);
    }
}