import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1,o2) -> {
            if(o1[col-1] == o2[col-1]) return o2[0] - o1[0];
            return o1[col-1] - o2[col-1];
        });
     
        int ans = -1;
        for(int i = row_begin-1; i < row_end; i++){
            int temp = 0;
            for(int j = 0; j < data[0].length; j++) {
                temp += data[i][j]%(i+1);
            }
            if( ans == -1) ans = temp; 
            else {
                ans = ans^temp;
            }
        }
        
        return ans;     
    }
}