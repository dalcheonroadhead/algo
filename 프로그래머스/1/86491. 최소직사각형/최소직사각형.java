class Solution {
    public int solution(int[][] sizes) {
        int GARO = 0;
        int SERO = 0;
        
        for(int i = 0; i <sizes.length; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];
            
            int garo = Math.max(a,b);
            int sero = Math.min(a,b);
            
            GARO = Math.max(GARO, garo);
            SERO = Math.max(SERO, sero);
        }
        return GARO * SERO;
    }
}