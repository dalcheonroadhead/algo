import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a-b));
        for(int now : scoville){
            pq.add(now);
        }
        
        int cnt = 0;
        while(pq.peek() < K){
            if(pq.size() <= 1) return -1; 
            int first = pq.poll();
            int second = pq.poll();
            int mix = mix(first, second);
            pq.add(mix);
            cnt++;
        }
        
        return cnt;
        
        
    }
    
    public int mix (int first, int second){
        return (first + second*2);
    }
}