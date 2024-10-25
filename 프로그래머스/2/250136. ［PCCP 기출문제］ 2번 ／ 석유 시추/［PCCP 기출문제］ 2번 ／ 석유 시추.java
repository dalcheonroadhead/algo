import java.io.*;
import java.util.*;

class Solution {
    // 1. make one dimension array which represent land array's column to store amount oil in each column; 
    // 2. return Max amount 
    static int [] oils;
    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(int[][] land) {
        oils = new int[land[0].length];
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[i].length; j++){
                if(land[i][j] == 1) bfs(i,j,land);
            }
        }
        Arrays.sort(oils);
        return oils[oils.length-1];
    }
    

    
    
    public void bfs (int r, int c, int [][] land){
        // 0 = soil, 1 = oil, 2 = visited already
        ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        aq1.add(new Coordinate(r,c));
        set.add(c);
        land[r][c] = 2;
        int acc = 1;
        while(!aq1.isEmpty()){
            Coordinate now = aq1.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = now.r + dir[i][0];
                int nc = now.c + dir[i][1];
                
                if(nr >= land.length || nr < 0 || nc >= land[0].length || nc < 0) continue;
                if(land[nr][nc] == 0 || land[nr][nc] == 2) continue;
                acc++;
                land[nr][nc] = 2;
                set.add(nc);
                aq1.add(new Coordinate(nr,nc));
            }
        }
        
        for(int column : set){
            oils[column] += acc;
        }
    }
}

class Coordinate {
    int r; 
    int c; 
    
    public Coordinate (int r, int c){
        this.r = r;
        this.c = c;
    }
}