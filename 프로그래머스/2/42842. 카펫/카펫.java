class Solution {
    public int[] solution(int brown, int yellow) {
        int half = brown/2;     
        for(int i = half-1; i > 2; i--) {   
            int garo = i;
            int sero = half - garo + 2;
            if(isOk(garo,sero, yellow)) return new int[]{garo, sero};
        }
        
        return new int[]{};
    }
    
    
    public boolean isOk(int garo, int sero, int yellow) {
        return (yellow == (garo-2) * (sero-2));
    }
}