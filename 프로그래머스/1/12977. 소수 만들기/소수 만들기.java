class Solution {
    
    static int [] arr;
    static boolean [] isVisited;
    static int cnt = 0;
    
    public int solution(int[] nums) {
        arr = new int [nums.length];
        isVisited = new boolean[nums.length];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = nums[i];
        }
        
        combination(0, 0);
        
        return cnt;
    }
    
    public void combination(int depth, int start) {
        if(depth == 3){
            int v = 0;
            // 선택된 수들을 합해서 후보 값을 만든다.
            for(int i = 0; i < isVisited.length; i ++){
                if(isVisited[i]){
                    v += arr[i];
                }
            }
            // 만약 후보값이 전체의 절반의 수 중 하나라도 나누어 떨어지면 소수가 아니다.
            for(int i = 0; i <= v/2; i ++){
                
                if(i == 0 || i == 1) continue;
                
                if(v%i == 0) {
                    return;
                }
            }
            // 그렇지 않다면 소수임으로 소수 개수를 하나 카운트 한다.
            cnt++;
            return; 
        }
        
        for(int i = start; i < arr.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true; 
                combination(depth+1, i+1);
                isVisited[i] = false;
            }
        }
    }
}