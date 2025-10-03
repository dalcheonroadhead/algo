import java.util.*;

class Solution {
    static int R,C;
    public int solution(int[][] land) {
        int answer = 0;
        R = land.length;
        C = land[0].length;
        boolean [][] oil = new boolean [R][C];
        int [] col = new int [C];
        for (int i = 0; i < R; i++){
            for (int  j = 0; j <  C; j++){
                if(land[i][j] != 0 && !oil[i][j]) bfs(i,j, oil, land, col);
            }
        }
        Arrays.sort(col);
        return col[C-1];
    }
    
   
    
    public void bfs (int r, int c, boolean [][] oil, int [][] land, int [] col) {
        int [][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int sum = 1;
        ArrayDeque<int[]> aq1 = new ArrayDeque<>();
        aq1.add(new int[]{r,c});
        oil[r][c] = true;
        boolean [] cols = new boolean [C];
        cols[c] = true;
        while(!aq1.isEmpty()){
            int [] now = aq1.poll();
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dir[i][0];
                int nc = now[1] + dir[i][1];
                if(OOB(nr,nc)) continue;
                if(land[nr][nc] != 1) continue;
                if(oil[nr][nc]) continue;
                oil[nr][nc] = true;
                cols[nc] = true;
                sum++;
                aq1.add(new int[]{nr,nc});
            }
        }
        
        for(int i = 0; i < C; i++){
            if(cols[i]) col[i] += sum;
        }
       
    }
    
    public boolean OOB (int r, int c) {
        return r < 0 || c < 0 || r >= R || c>=C;
    }
}