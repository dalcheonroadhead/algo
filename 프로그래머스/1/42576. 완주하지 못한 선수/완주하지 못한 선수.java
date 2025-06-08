import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String now : participant){
            map.compute(now, (k,ov)-> ov==null? 1 : ov+1);
        }
        
        for(String now : completion) {
            map.compute(now, (k,ov) -> ov-1  <= 0? null : ov-1);
        }
        
        for(String now : map.keySet()) {
            return now;
        }
        return "";    
    }
}