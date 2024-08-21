import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<Integer> [] lists = new ArrayList [n];
        boolean [] isVisited = new boolean [n];
        
        for(int i = 0; i < n; i++){
            lists[i] = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    if(i==j) continue;
                    lists[i].add(j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                answer++;
                bfs(lists,isVisited, i);
            }
        }
        
        return answer;
    }
    
    public void bfs(ArrayList<Integer> [] lists, boolean [] isVisited, int node) {
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(node);
        isVisited[node] = true;
        
        while(!aq1.isEmpty()){
            int now = aq1.poll();
            for(int i = 0; i < lists[now].size(); i++){
                int next = lists[now].get(i);
                if(!isVisited[next]){
                    isVisited[next] = true;
                    aq1.add(next);
                }
            }
        }
    }
}