import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0; i < record.length; i++){
            StringTokenizer  st = new StringTokenizer(record[i]);
            
            String order    = st.nextToken();
            String id       = st.nextToken();
            String nickname = null;
            if(!order.equals("Leave")){
                nickname = st.nextToken();
            }
            
            if(order.equals("Enter") || order.equals("Change")){
                map.put(id, nickname);
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            StringTokenizer st = new StringTokenizer(record[i]);
            String order    = st.nextToken();
            String id       = st.nextToken();
            String nickname = map.get(id);
            

            
            switch(order){
                case "Enter":
                    sb.append(nickname).append("님이 들어왔습니다.");
                    break;
                case "Leave":
                    sb.append(nickname).append("님이 나갔습니다.");
                    break;
                case "Change":
                    continue;
            }
         
            list.add(sb.toString());
        }
        
        String [] answer = new String [list.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}