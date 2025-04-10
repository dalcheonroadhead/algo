import java.util.*;

class Solution {
    private String suffix;          // 접미사
    private String threshold;       // 한계점
    private long [] memo;           // 한계점에 다다르지 않는 경우의 계산을 위한 캐싱 
    private int digitLimit;         // 자릿수 한계

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.suffix = s;
        this.digitLimit = limit;
        // 1. 0 ~ start-1 까지 모든 조건을 만족하는 값의 개수 구하기
        threshold = String.valueOf(start - 1);
        memo = new long [20];
        long count2Start = dfs(0, true);

        // 2. 0 ~ finish까지 모든 조건을 만족하는 값의 개수 구하기
        threshold = String.valueOf(finish);
        memo = new long [20];
        long count2Finish = dfs(0, true);

        return count2Finish - count2Start;
    }

    // pos = 현재 자릿수, isLimit = 최고 높은 자릿수부터 직전 자릿수까지 모두 조건에서 제안한 한계치를 찍었는가?
    private long dfs(int pos, boolean isLimit) {
        // 1-1) (예외 처리) 최대치의 자릿수보다 접미사의 자릿수가 크다면, 유효한 숫자는 아무것도 없다. 
        if(threshold.length() < suffix.length()) return 0;
        // 1-2) (예외 처리) 현재까지 한계치를 갔다 오지 않았다면, 어짜피 뒤는 중복된 계산이 쭉 이어짐 (0 ~ limit까지 계산한 내용들).
        //      따라서 최초 한 번 계산한 것을 돌려쓴다.
        if(!isLimit && memo[pos] != 0L) return memo[pos];

        // 2) (기저 조건 BASE CASE) 만약 접미사가 시작하는 부분에 현재 도달했다면, 다음을 통해 현재까지 만든 숫자의 유효성을 확인
        if(threshold.length() - pos == suffix.length()) {
            // a. 지금까지 정한 모든 자릿수가 최대크기가 아니라면 그냥 1 반환 (답의 총 개수에 누적 +1 되는 거임)
            // b. 만약 지금까지 모든 자릿수가 최대크기를 따라왔다면? 접미사가 한계치의 접미사 영역 부분 값보다 작으면 유효(+1), 아니면 무효(+0)
            return isLimit? (suffix.compareTo(threshold.substring(pos)) <= 0? 1 : 0) : 1;
        }
        // 3) 다음 자릿수의 한계를 정하기
            // a. 현재까지 한계점을 계속 밟아왔다면, 다음 값도 한계치가 최대
            // b. 현재까지 한계점을 계속 밟아온 게 아니라면, 다음 값은 0~9중 어떤 것이어도 된다.
            // c. a,b 중 뭐가 되었든 값이 한계치를 벗어나서는 안된다.
        int nextLimit = Math.min(digitLimit, (isLimit? threshold.charAt(pos) - '0' : 9));
        long validCnt = 0;

        for(int i = 0; i <= nextLimit; i++){
            // 다음 자리로 간다. + 지금까지 한계점을 사용했으며, 이번 자릿수도 한계 자릿수를 사용했다는 상태표시
            validCnt += dfs(pos + 1, isLimit && (threshold.charAt(pos) - '0') == i);
        }

        if(!isLimit) memo[pos] = validCnt;

        return validCnt;
    }
}