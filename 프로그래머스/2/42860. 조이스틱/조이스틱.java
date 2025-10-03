class Solution {
    public int solution(String name) {
        int answer = 0;
        int change = 0; // 상하로 조이스틱 움직여서 문자 바꿀 때 최소 이동 횟수 저장
        int move = name.length() - 1; // 좌우로 조이스틱 움직여서 문자 바꿀 떄 최소 이동 횟수 저장
        
        for(int i = 0; i < name.length(); i++){
            change += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i) + 1);
        }
        
        for(int i = 0; i < name.length(); i++){
            int j = i+1;
            while (j < name.length() && name.charAt(j) == 'A') j++;
            move = Math.min(move, (i*2) + name.length() - j);
            move = Math.min(move, (name.length()-j)*2 + i);
        }
        answer = change + move;
        return answer;
    }
}