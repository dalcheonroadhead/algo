import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Vertex> [] lists;
    static int N;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 0. initialize values;
        N = n;
        lists = new ArrayList [n+1];
        for(int i = 0; i < n+1; i++){
            lists[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < fares.length; i++){
            int start = fares[i][0];
            int end   = fares[i][1];
            int weight = fares[i][2];
            
            lists[start].add(new Vertex(end, weight));
            lists[end].add(new Vertex(start,weight));
        }
        
        int [] together = dijstra(s);   // 시작 정점에서 모든 정점까지의 최단거리 배열
        int ans = Integer.MAX_VALUE;    
        for(int i = 1; i < n+1; i++){   // 경유지 찾기
            int [] alone = dijstra(i);  // 경유지에서 모든 정점까지의 최단거리 배열  
            ans = Math.min(ans, together[i] + alone[a] + alone[b]);
        }
        
        return ans;
        
    }
    
    public int[] dijstra(int start) {
        int [] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1,o2) -> o1.cost -o2.cost);
        pq.add(new Vertex(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Vertex now = pq.poll();
            if(now.cost > dist[now.idx]) continue;
            
            for(int i = 0; i < lists[now.idx].size(); i++){
                Vertex next = lists[now.idx].get(i);
                if(next.cost + dist[now.idx] < dist[next.idx]){
                    dist[next.idx] = next.cost + dist[now.idx];
                    pq.add(new Vertex(next.idx, dist[next.idx]));
                }
            }
        }
        
        return dist;
    }
}

class Vertex{
    int idx;
    int cost;
    
    public Vertex(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}
