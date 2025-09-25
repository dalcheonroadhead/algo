import java.util.*;

class Solution {
    
    static class Coor {
        int r;
        int c;
        int cnt;
        
        Coor (int r, int c){
            this.r = r;
            this.c = c;
            this.cnt = 0;
        }
        
        Coor (int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int [][] dir = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}};    
    static int [][] map = new int [102][102]; // 2 = 둘레, 1 = 내용물
    
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for (int i = 0; i < rectangle.length; i++){
            paint (new int [] {rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2});
        }
        answer = bfs(characterY*2, characterX*2, itemY*2, itemX*2);
        
        for (int i = 0; i <= 18 ; i++){
            for (int j = 0; j <= 18 ; j++){
                if(map[i][j] == 8) System.out.print("s" + " ");
                else if(map[i][j] == 9) System.out.print("g" + " ");
                else if (map[i][j] == 7) System.out.print("d"+" ");
                else System.out.print("_" + " ");
            }
            System.out.println();
        }
        
        return answer/2;
    }
    
    
    public void paint (int [] rect) {
        for (int r = rect[1]; r <= rect[3]; r++){
            for (int c = rect[0]; c <= rect[2]; c++){
                if((r == rect[1] || r == rect[3] || c == rect[0] || c == rect[2]) && map[r][c] != 1) map[r][c] = 2;
                else map[r][c] = 1;
            }
        }
    }
    
    public int bfs(int startR, int startC, int destR, int destC) {
        ArrayDeque<Coor> aq1 = new ArrayDeque<>();
        map[startR][startC] = 8;
        aq1.add(new Coor(startR, startC));
        
        while(!aq1.isEmpty()) {
            Coor now = aq1.poll();
            
            if(now.r == destR && now.c == destC){
                map[destR][destC] = 7;
                return now.cnt;
            }
            
            for(int i = 0; i < 4; i++){
                int newR = now.r + dir[i][0];
                int newC = now.c + dir[i][1];
                if(OOB(newR, newC)) continue;
                if(map[newR][newC] != 2) continue;
                map[newR][newC] = 9;
                aq1.add(new Coor (newR, newC, now.cnt+1));
            }
        }
        
        return -9999;
    } 
    
    public boolean OOB (int r, int c){
        return r < 0 || c <0 || r >= 102 || c >= 102;
    }
}

