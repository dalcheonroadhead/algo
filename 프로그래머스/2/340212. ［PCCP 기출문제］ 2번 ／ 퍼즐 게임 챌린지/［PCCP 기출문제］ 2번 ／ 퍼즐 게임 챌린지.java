// 1. 이분 탐색 
class Solution {
    
    static class Problem {
        int d;
        int t;
        
        public Problem (int d, int t){
            this.d = d;
            this.t = t;
        }
    }
    static long L;
    static Problem [] p;
    
    public int solution(int[] diffs, int[] times, long limit) {
        long answer = 0;
        L = limit;
        p = new Problem [diffs.length];
        
        
        for(int i = 0; i < diffs.length; i++){
            p[i] = new Problem (diffs[i], times[i]);
        }
        answer = (int)binary_search();
        System.out.println(answer);
        return (int)answer;
    }
    
    public long binary_search() {
        long start = 1;
        long end = 1_000_000_000_000_000L;
        
        while (start <= end) {
            long mid = (start + end)/2;
            if(!isOk(mid)) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
    
    public boolean isOk (long level){ // 제한 시간을 넘니? 
        
        long sum = 0; // 실제 처리 시간
        long prev = 0; // 이전까지의 시간을 단순 누적한 값
        for(int i = 0 ; i < p.length; i++){
            Problem now = p[i];
            if(i != 0) prev = p[i].t + p[i-1].t; 
            if(now.d <= level) sum += now.t;
            else {
                sum += now.t + (now.d - level)*prev;
            }
            // if(sum > L) return false; // 총 걸린 시간이 이미 limit을 넘었다. -> level을 올려야 함.
        }
        return sum > L? false : true; 
    }
}