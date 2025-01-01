import java.util.*;


class Solution {
    public String solution(int[] numbers) {
        Integer [] arr = new Integer [numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = numbers[i];
        }
        
        Arrays.sort(arr, (a, b) -> {
            String sA = Integer.toString(a);
            String sB = Integer.toString(b);
            
            String temp1 = sA+sB;
            String temp2 = sB+sA;
            
            int ab = Integer.parseInt(temp1);
            int ba = Integer.parseInt(temp2);
            
            if(ab > ba) return -1;
            else if (ab == ba) return 0;
            else return 1;
        });
        
        return join(arr);
    }
    
    public String join (Integer [] arr) {
        StringBuilder sb = new StringBuilder();
        int zero_cnt = 0;
        
        for(Integer i : arr){
            if(i == 0) zero_cnt++;
            sb.append(i);
        }
        if(zero_cnt == arr.length) {
            sb.setLength(0);
            sb.append("0");
        }
        
        return sb.toString();
    }
}