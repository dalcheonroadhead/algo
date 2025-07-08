import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            char order = st.nextToken().charAt(0);
            int value = Integer.parseInt(st.nextToken());
            
            switch (order) {
                case 'I': {
                    maxHeap.add(value);
                    minHeap.add(value);
                    map.put(value, value);
                    break;
                }
                case 'D': {
                    PriorityQueue<Integer> now;
                    if(value == 1){ 
                        now = maxHeap;
                    }else {
                        now = minHeap;
                    }
                    while(now.size() > 0){
                        int out = now.poll();
                        if(map.get(out) != null){
                            map.remove(out);
                            break;
                        }
                    }   
                    break;
                }
            }
        }
        
        while(maxHeap.size() > 0){
            int peek = maxHeap.peek();
            if(map.get(peek) == null) maxHeap.poll();
            else break;
        }
        
        while(minHeap.size() > 0) {
            int peek = minHeap.peek();
            if(map.get(peek) == null) minHeap.poll();
            else break;
        }
        
        if(maxHeap.size() == 0 && minHeap.size() == 0) return new int [] {0,0};
        else return new int [] {maxHeap.peek(), minHeap.peek()};
    }
}