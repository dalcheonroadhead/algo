class Solution {
    public long solution(int n) {      
        long [] dp = new long [n+1];
        // 초기 값 설정
        dp[2] = 3;
        
        for(int i = 4; i <= n; i+=2){
            // 초기 값 설정 (이전 꺼 * dp[2] 인 경우의 수 + 영역 범람하여 만들 수 있는 경우의 수 2개)
            dp[i] = dp[i-2]*dp[2] + 2;
            
            // dp 값 완성
            for(int j = 2; j <= i-4; j+=2) {
                dp[i] += dp[j]*2;    
            }
            
            dp[i] = dp[i]%1000000007;
        }
        
        return dp[n];
        
    }
}