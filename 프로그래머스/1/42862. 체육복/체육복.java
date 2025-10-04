class Solution {
    static boolean [][] student; // 0열 = 도난당했는가? // 1열 = 여벌이 있는가? // 2열 = 체육수업 참여가 가능한가?
    
    public int solution(int n, int[] lost, int[] reserve) {
        student = new boolean [n][3];
        
        for(int i = 0; i < lost.length; i++){
            student[lost[i]-1][0] = true;
        }
        
        for(int i = 0; i < reserve.length; i++){
            student[reserve[i]-1][1] = true;
        }
        
        for (int i = 0; i < n; i++){
            // 1. 도난 안당했고 여벌의 옷은 없다. -> 체육수업 참여 외에 할 수 있는게 없다.
            // 2. 도난 당하고 여벌의 옷이 있다. -> 체육 수업 참여외에 할 게 없다.
            if(( !student[i][0] && !student[i][1] ) || ( student[i][0] && student[i][1])) {
                student[i][2] = true;
                continue;
            }
            // 3. 도난 안 당하고 여벌의 옷이 있다. 
            if(!student[i][0] && student[i][1]) {
                student[i][2] = true;
                // 3-1 이전 번호 친구가 도난당했고 여벌의 옷이 없으며 도와줄 사람도 없다..
                if((i-1) >=0 && student[i-1][0] && !student[i-1][1] && !student[i-1][2]){
                    student[i-1][2] = true;
                    continue;
                }
                // 3-2 다음 번호 친구가 도난 당했고, 여벌의 옷이 없으며 누가 아직 구해주지도 않았다.
                if((i+1) < n && student[i+1][0]  && !student[i+1][1] && !student[i+1][2]){
                    student[i+1][2] = true;
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(student[i][2]) answer++;
        }
        return answer;
    }
}