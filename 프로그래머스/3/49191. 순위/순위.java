import java.io.*;
import java.util.*;

class Solution {
    static int N;
    static ArrayList<Integer> [] lose;
    static ArrayList<Integer> [] win;
    static int ans = 0;
    
    public int solution(int n, int[][] results) {
        N    = n;
        lose = new ArrayList [n+1];
        win  = new ArrayList [n+1];
        
        for(int i = 1; i <= n; i ++){
            lose[i] = new ArrayList<>();
            win[i]  = new ArrayList<>();
        }
        
        for(int i = 0; i < results.length; i++){
            int winner = results[i][0];
            int loser  = results[i][1];
            lose[loser].add(winner);
            win[winner].add(loser);
        }
        
        for(int i = 1; i<= n; i++){
            int cnt = 0;
            cnt += bfs(true, i);
            cnt += bfs(false, i);
            if (cnt == n-1) ans++;
        }
        
        return ans;
        
    }
    
    public int bfs(boolean isWinner, int now) {
        ArrayList<Integer> [] list =  isWinner? win : lose; // 현재 사용 중인 그래프 
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();       // BFS 용 queue
        boolean [] isVisited = new boolean[N+1];            // 방문 배열
        int cnt = 0;                                        // 승패가 확인된 개수
        aq1.add(now);
        isVisited[now] = true; 
        
        while(!aq1.isEmpty()){
            int cur = aq1.poll();
            
            for(int i = 0; i<list[cur].size(); i ++) {
                int next = list[cur].get(i);
                if(!isVisited[next]){
                    isVisited[next] = true; 
                    cnt++;
                    aq1.add(next);
                }
            }
        }
        return cnt;        
    }
}