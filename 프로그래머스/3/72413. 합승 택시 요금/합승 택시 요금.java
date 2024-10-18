import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Vertex> [] lists;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        lists = new ArrayList [n+1];
        
        for(int i = 1; i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }
        
        for(int i = 0; i <fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int weight = fares[i][2];
            lists[start].add(new Vertex(end, weight));
            lists[end].add(new Vertex(start, weight));
        }
        
        int [] togther = dijstra(s);
        int ans = togther[a] + togther[b]; // 따로 가는 것 
        for(int i = 1; i <= n; i++){            
            int [] alone = dijstra(i);
            ans = Math.min(ans, togther[i]+alone[a]+alone[b]);
        }
        return ans;
        
    }
    
    public int [] dijstra(int start){
        PriorityQueue<Vertex> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        int [] dist = new int [lists.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Vertex(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Vertex now = pq.poll();
            if(now.cost > dist[now.idx]) continue; 
          
            for(int i = 0; i < lists[now.idx].size(); i++){
                int nv = lists[now.idx].get(i).idx;
                int nDist = dist[now.idx] + lists[now.idx].get(i).cost; // (현재 정점까지의 최단거리 + 현 정점에서 nv까지의 간선 비용)
                
                if(dist[nv] > nDist){
                    dist[nv] = nDist;
                    pq.add(new Vertex(nv, nDist));
                }
            }
        }
        
        return dist;
    }
}

class Vertex {
    int idx;
    int cost;

    
    public Vertex (int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}