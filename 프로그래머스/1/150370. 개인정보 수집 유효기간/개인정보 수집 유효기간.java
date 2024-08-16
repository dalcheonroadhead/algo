import java.io.*;
import java.util.*;

class Solution {
    // 1. map에 값 저장 
    // 2. 저장한 개인정보를 기준으로, 파기해야할 날짜 계산 
        // (1) 달 + 저장기간 
        // (2) 달 + 저장기간이 12개월을 초과하면, 년도 +1
        // (3) 일은 현재 일자 -1 (만약 1일이라면 28일로 변경)
    // 3. today랑 비교해서 현재 파기해야하는지 확인
    
    static ArrayList<Integer> ans = new ArrayList<>();
    
    static HashMap<String, Integer> map = new HashMap<>();
    static int nowYear  = 0;
    static int nowMonth = 0;
    static int nowDays  = 0;
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        StringTokenizer dDay = new StringTokenizer(today, ".", false);
        nowYear     = Integer.parseInt(dDay.nextToken());
        nowMonth    = Integer.parseInt(dDay.nextToken());
        nowDays     = Integer.parseInt(dDay.nextToken());
        
        
        // map에 값 저장
        for(int i = 0; i < terms.length; i ++){
            StringTokenizer st = new StringTokenizer(terms[i], " ", false);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        // 만료일 계산
        for(int i = 0; i < privacies.length; i++){
            StringTokenizer outer = new StringTokenizer(privacies[i]);
            StringTokenizer inner = new StringTokenizer(outer.nextToken(), ".", false);
            if(isExpire(Integer.parseInt(inner.nextToken()),
                        Integer.parseInt(inner.nextToken()),
                        Integer.parseInt(inner.nextToken()), 
                        map.get(outer.nextToken()))) ans.add((i+1));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    public boolean isExpire(int year, int month, int day, int expire) {
        int input = year*12*28 + month*28 + day + expire*28; 
        int now = nowYear*12*28 + nowMonth*28 + nowDays; 
        
        return input <= now? true : false;
    }
}