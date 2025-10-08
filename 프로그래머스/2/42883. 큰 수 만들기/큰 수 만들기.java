import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char [] arr = new char[number.length() - k];
        int cnt = 0;
        int start = 0;
        int end = k;
        
        while(end < number.length()){
            int val = -1;
            int idx = -1;
            for(int i = start; i <= end; i++){
                if(val < number.charAt(i)-'0') {
                    val = number.charAt(i) - '0';
                    idx = i;
                }
            }
            // System.out.printf("index = %d값 계산 중, %d ~ %d 까지 범위 중 뽑힌 수는 (위치:%d, 값:%d) \n", cnt, start, end, idx, val);
            arr[cnt++] = (char)(val + '0');
            start = idx+1;
            end++;
        }
        
        System.out.println(start);
        return String.valueOf(arr);
    }
}