import java.io.*;
import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    
    //  1. map에 값을 저장
    //  2. 투 포인터 사용
    //  2-1. right 옮겨서 left와의 차가 3글자 이상 되면 Map에 값이 있는지 계속 확인 
    //  2-2. 있으면 해당 수를 숫자로 옮기고, left를 right 쪽으로 땡겨서 0에서 시작
    //  2-3. 없으면 한 칸 늘려서 또 map 들여다보고 확인
    //  2-5. 만약 숫자라면 그냥 건너 뛰기 
    
    public int solution(String s) {
        map.put("zero", 0);     map.put("five", 5);
        map.put("one",  1);     map.put("six",  6);
        map.put("two",  2);     map.put("seven",7);
        map.put("three",3);     map.put("eight",8);
        map.put("four", 4);     map.put("nine", 9);
        
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int right= 0;
        
        while(right < s.length()){
            char now = s.charAt(right++);
            if(now - 48 < 10){
                ans.append(now);
                continue;
            }
            word.append(now);
            if(word.toString().length() >= 3){
                int convert = map.getOrDefault(word.toString(), -1);
                if(convert == -1) continue; 
                else{
                    ans.append(convert);
                    word.setLength(0);
                }
            }
        }
        
        return Integer.parseInt(ans.toString());
    }
}