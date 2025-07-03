import java.util.*;

class Solution {
    
    static class Task {
        int progress;
        int speed;
        
        public Task(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Task> aq1 = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            aq1.add(new Task(progresses[i], speeds[i]));
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!aq1.isEmpty()){
            int qSize = aq1.size();
            boolean canPoll = false;
            int cnt = 0; 
            for(int i = 0; i <qSize; i++){
                Task now = aq1.poll();
                now.progress += now.speed;
                
                if(now.progress >= 100 && i == 0) canPoll = true;
                if(now.progress >= 100 && canPoll) cnt++;
                else {
                    canPoll = false;    
                    aq1.add(now);
                }
            }
            if(cnt > 0) list.add(cnt);
        }
        
        int [] answer = new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}