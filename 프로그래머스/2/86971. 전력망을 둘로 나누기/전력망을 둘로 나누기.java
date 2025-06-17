import java.util.*;

class Solution {
    static ArrayList<Integer> [] lists;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        lists = new ArrayList [n + 1];
        
        for(int i = 1; i < n+1; i++){
            lists[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int left = wires[i][0];
            int right = wires[i][1];
            
            lists[left].add(right);
            lists[right].add(left);
        }
        
        
        for(int i = 0; i < wires.length; i++){
            int left = wires[i][0];
            int right = wires[i][1];
            
            lists[left].remove(Integer.valueOf(right));
            lists[right].remove(Integer.valueOf(left));
            
            int left_cnt = bfs(left, n);
            int right_cnt = bfs(right, n);
            
            answer = Math.min(answer, Math.abs(left_cnt - right_cnt));
            
            lists[left].add(right);
            lists[right].add(left);
        }
        return answer;
    }
    
    public int bfs(int start, int n) {
        int answer = 0;
        boolean [] isVisited = new boolean [n+1];
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        isVisited[start] = true;
        aq1.add(start); 
        
        while(!aq1.isEmpty()){
            int now = aq1.poll();
            for(int i = 0; i < lists[now].size(); i++){
                int next = lists[now].get(i);
                if(isVisited[next]) continue;
                answer++;
                isVisited[next] =true;
                aq1.add(next);
            }
        }
        
        return answer;
    }
}