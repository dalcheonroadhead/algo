import java.util.*;

class Solution {
    static class Bridge {
        int l;
        int w;
        int acc_cnt;
        int acc_w;
        int [] loc;
        
        public Bridge(int l, int w){
            this.l = l;
            this.w = w;
            this.acc_cnt = 0;
            this.acc_w = 0;
            this.loc = new int [l];
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(bridge_length, weight);
        ArrayDeque<Integer> bus = new ArrayDeque<>();
        
        for(int i = 0; i < truck_weights.length; i++){
            bus.add(truck_weights[i]);
        }
        int time = 0;
        while(!bus.isEmpty() || bridge.acc_cnt != 0){
            // 시간 흐르기
            time++;
            // 다리 건널 수 있는 버스 빼기
            if(bridge.loc[bridge.l-1] != 0) {
                bridge.acc_w -= bridge.loc[bridge.l-1];
                bridge.acc_cnt -= 1;
                bridge.loc[bridge.l-1] = 0;
            }
            // 다리 위 버스 한칸씩 진행
            int [] temp = new int [bridge.l];
            for(int i = 1; i < bridge.l; i++){
                temp[i] = bridge.loc[i-1];
            }
            bridge.loc = temp;
            // 다음 버스 넣을 수 있는지 확인
            if(!bus.isEmpty()){
                if(bus.peek() + bridge.acc_w > bridge.w || bridge.acc_cnt + 1 > bridge.l) continue;
                int now_weight = bus.poll();
                bridge.loc[0] = now_weight;
                bridge.acc_cnt ++;
                bridge.acc_w += now_weight;
            }
        }
        return time;
    }
}