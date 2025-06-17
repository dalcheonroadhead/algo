class Solution {
    static int answer = 0;
    static int n, K; 
    static boolean [] isVisited;
    static int [][] d;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        K = k;
        isVisited = new boolean [n];
        d = new int [n][2];
        
        for(int i = 0; i < n; i++){
            d[i][0] = dungeons[i][0];
            d[i][1] = dungeons[i][1];
        }
        
        permutation(new int [n], 0);
        
        return answer;
    }
    
    public void permutation(int [] arr, int depth) {
        if(depth == n) {
            int hp = K;
            int cnt = 0; 
            for(int i = 0; i < n; i++) {
                int need = d[arr[i]][0];
                int cost = d[arr[i]][1];
                
                if(need > hp) break;
                
                hp -= cost;
                cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(isVisited[i]) continue;
            
            isVisited[i] = true;
            arr[depth] = i;
            permutation(arr, depth+1);
            isVisited[i] = false;
        }
    }
}