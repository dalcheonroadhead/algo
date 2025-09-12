import java.util.*;

class Solution {
    static int N;
    static int [][] map;
    public int[] solution(int n) {
        N = n;
        map = new int [n][n];
        
        int value = 0;
        int turn = 0;
        
        while(true) {
            int initial= value;
            value = down(turn, value);
            
            if(initial == value) break;
            else initial = value;
            
            value = right(turn, value);
            
            if(initial == value) break;
            else initial = value;
            
            value = up(turn, value);
            
            if(initial == value) break;
            else initial = value;
            
            turn++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int [] row : map){
            for(int temp : row){
                if(temp == 0) continue;
                ans.add(temp);
            }
        }
        
        // for(int [] row : map){
        //     System.out.println (Arrays.toString(row));
        // }
        
        int [] answer = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
;        
        return answer;
        
    }
    
    public int down (int turn, int value){
        int r = turn*2;
        int c = turn;
        while(!OOB(r,c) && map[r][c] == 0){
            map[r][c] = ++value;
            // print(r,c,value);
            r++;
        }
        return value;
    }
    
    public int right (int turn, int value){
        int r = (N-1)-turn;
        int c = turn + 1;
        while(!OOB(r,c) && map[r][c] == 0){
            map[r][c] = ++value;
            // print(r,c,value);
            c++;
            
        }
        return value;
    }
    
    public int up (int turn, int value){
        int r = (N-1) - turn -1;
        int c = (N-1) - (turn*2) - 1;
        
        while(!OOB(r,c) && map[r][c] == 0){
            map[r][c] = ++value;
            // print(r,c,value);
            r--; c--;
        }
        return value;
    }
    
    public boolean OOB(int r, int c){
        return r < 0 || c < 0 || r>=N || c >=N;
    }
    
    public void print(int r, int c, int v){
        System.out.printf("%d, %d : %d \n", r,c,v);
    }
}