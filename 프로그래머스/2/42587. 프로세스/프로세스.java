import java.util.*;

class Solution {
    static class Ps {
        int p; // 우선순위
        int ol; // 원래 번호
        
        public Ps(int p, int ol) {
            this.p = p;
            this.ol = ol;
        }
    }
    
    public int solution(int[] priorities, int location) {
        PriorityQueue<Ps> pg = new PriorityQueue<>((p1,p2) -> (p2.p - p1.p));
        ArrayDeque<Ps> os = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++){
            Ps now = new Ps(priorities[i], i);
            pg.add(now);
            os.add(now);
        }
        int num = 0;
        while(!os.isEmpty()){
            Ps top = pg.peek();
            Ps now = os.poll();
            if(top.p == now.p) {
                pg.poll();
                num++;
                if(now.ol == location) return num;
            }else{
                os.add(now);
            }
        }
        return num;
    }
}