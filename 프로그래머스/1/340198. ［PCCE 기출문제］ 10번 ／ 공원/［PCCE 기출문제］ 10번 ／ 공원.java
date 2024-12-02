import java.util.*;

class Solution {

    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
 
        int row = park.length;
        int col = park[0].length;
        
        Arrays.sort(mats);
        
        universe:
        for(int i = mats.length-1; i>= 0; i--){
            
            int now = mats[i];
            
            for(int j = 0; j <= row - now; j++){
                for(int k = 0; k <= col - now; k++){
                    boolean isNowClear = true;
                    
                    earth:
                    for(int a = j; a < j + now; a++){
                        for(int b = k; b < k + now; b++){
                            if(!park[a][b].equals("-1")){
                                isNowClear = false;
                                break earth;
                            }
                        }
                    }
                    
                    if(isNowClear) {
                        answer = now;
                        break universe;
                    }
                }
            }
            
        }
        return answer;
    }
}