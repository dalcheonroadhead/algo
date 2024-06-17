import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < participant.length; i ++){
            if(map.putIfAbsent(participant[i], 1) != null){
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }
        
        for(int i = 0; i < completion.length; i ++){
            if(map.get(completion[i]) == null){
                return completion[i];
            }else {
                map.put(completion[i], map.get(completion[i])-1);
            }
        }
        
        for(int i = 0; i < map.size(); i ++){
            if(map.get(participant[i]) > 0){
                return participant[i];
            }
        }
        

        
        

        
        
        return "여기까지 안 옴";
        
    }
}