import java.util.*;

class Solution {
    // bfs로 푼다.
    // 인접 리스트를 만든다.
    // wires에서 끊어낼 값을 하나 선택하고 끊어낸 두 노드를 시작점으로 BFS를 타본다.
    // 그 차이로 최소값을 갱신한다.
    
    static ArrayList<Integer> [] lists;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        lists = new ArrayList [n+1];
        
        for(int i = 0; i < n+1; i++){
            lists[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];

            lists[start].add(end);
            lists[end].add(start);
        }
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            bfs(a,b);
        }
        return min;
    }
    
    
    public void bfs(int a, int b){
        boolean [] check = new boolean[lists.length];
        check[a] = check[b] = true;
        int a_cnt = 0;
        int b_cnt = 0;
        
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        aq1.add(a);
        
        while(!aq1.isEmpty()) {
            int now = aq1.poll();
            
            for(int i = 0; i < lists[now].size(); i++){
                int next = lists[now].get(i);
                if(check[next]) continue;
                
                check[next] = true;
                a_cnt++;
                aq1.add(next);
            }
        }
        
        aq1.add(b);
        while(!aq1.isEmpty()) {
            int now = aq1.poll();
            
            for(int i = 0; i < lists[now].size(); i++){
                int next = lists[now].get(i);
                if(check[next]) continue;
                
                check[next] = true;
                b_cnt++;
                aq1.add(next);
            }
        }
        
        min = Math.min(min, Math.abs(a_cnt-b_cnt));
    }
}