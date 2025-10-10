import java.util.*;

class Solution {
    static class Edge {
        int dest;
        int cost;
        
        public Edge(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    static boolean [] check;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        check = new boolean[n+1];
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        pq.add(new Edge(0,0));
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if(check[now.dest]) continue;
            check[now.dest] = true;
            answer += now.cost;
            for(int i = 0; i < graph.get(now.dest).size(); i++){
                Edge next = graph.get(now.dest).get(i);
                if(check[next.dest]) continue;
                pq.add(new Edge(next.dest, next.cost));
            }
        }
        
        return answer;
    }
}