import java.util.*;

class Solution {
    
    static class Job {
        int i; // 번호
        int t; // 요청 시각
        int w; // 소요 시간
        
        public Job (int i, int t, int w){
            this.i = i;
            this.t = t;
            this.w = w;
        }
        
        @Override
        public String toString(){
            return "일 번호: " + i + " 요청 시각:" + t + " 소요 시간:" + w; 
        }
    }
    
    static class Disk {
        int iter; // 작업 도는 지시자
        int amount_work_time; // 일 수행 시간 총량
        int done_cnt; // 끝낸 일 수
        int end; // 현재 맡은 일이 끝나는 시간
        
        public Disk () {
            this.iter = 0;
            this.amount_work_time = 0;
            this.done_cnt = 0;
            this.end = 0;
        }
        
    }
    
    public int solution(int[][] jobs) {

        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2)-> {
            if(j1.t == j2.t && j1.w == j2.w) return j1.i - j2.i;
            if(j1.w == j2.w) return j1.t - j2.t;
            return j1.w - j2.w; });
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);   
        Disk disk = new Disk();
        
        while(disk.done_cnt < jobs.length){
            
            while(disk.iter < jobs.length && disk.end >= jobs[disk.iter][0]) {
                pq.add(new Job(disk.iter, jobs[disk.iter][0], jobs[disk.iter][1]));
                disk.iter++;
            }
            
            if(pq.isEmpty()){ // 0ms 때의 작업이 없다.
                if(disk.iter < jobs.length) disk.end = jobs[disk.iter][0];
            }else {
                Job now = pq.poll();
                disk.amount_work_time += disk.end + now.w - now.t;
                disk.end += now.w;
                disk.done_cnt++;
                System.out.println(disk.end + now.w - now.t);
            }
            
        }
        
        return disk.amount_work_time/jobs.length;
    }
}