import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) { 
        int answer = Integer.MAX_VALUE; // 최단 문자열 길이 저장할 곳 
        if(s.length() == 1) return 1;   // 예외 처리 
        for(int i = 1; i <=s.length()/2; i++){
            StringBuffer sb = new StringBuffer(); // 압축 결과 문자열 
            String prevStr = "";                  // 비교용 이전 문자열 
            int count = 1;                        // 연속 개수 
            // 단위 별로 문자열 자르기 
            for(int j = 0; j <= s.length()-i; j += i){ // i씩 더한다. 
                String curStr = s.substring(j, j+i); // -> 두 번째 인자는 포함 안됨.
                if(prevStr.equals(curStr)){
                    count++;                        // 반복횟수++
                    continue;
                } else if(count > 1){
                    sb.append(count + prevStr);     // 현 문자열이 이전 문자열이랑 다르다.-> 답변에 추가 
                    count = 1; 
                } else {
                    sb.append(prevStr);
                }
                
                prevStr = curStr;                   // 비교 문자열 갱신
            } 
            // 맨마지막에 갱신된 문자열은 prevStr에 저장된 채 본 답변 StringBuilder에 저장되지 않는다.
            sb.append(count > 1? count+prevStr : prevStr);
            // s의 길이가 압축 단위로 나누어 떨어지지 않으면, 남는 부분 추가 
            if(s.length()%i != 0){
                sb.append(s.substring(s.length() - s.length()%i, s.length()));
            }
            
            answer = Math.min(answer, sb.length());
            sb = new StringBuffer();
        }
        return answer;
    }
}