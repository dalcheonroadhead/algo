import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 음악(고유번호, 장르, 플레이 횟수) 객체를 저장
        List<Music> playList = new ArrayList<>();
        // 2. 장르별 총 플레이 횟수를 저장
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 3. 장르별 곡 개수를 저장 
        Map<String, Integer> genreCount = new HashMap<>();
        
        // 입력 값을 1~3 설명에 맞게 변형하여 저장
        for (int i = 0; i < genres.length; i++) {
            // 1.
            playList.add(new Music(i, genres[i], plays[i]));
            // 2.
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            // 3.
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + 1);
        }
        
        // 플레이리스트 정렬
        playList.sort((o1, o2) -> {
            // 장르도 같고, 플레이 횟수도 같으면 고유번호로 오름차순
            if (o1.genre.equals(o2.genre) && o2.play == o1.play) {
                return o1.num - o2.num;
            }
            // 장르가 같다면 플레이 횟수로 내림차순
            if (o1.genre.equals(o2.genre)) {
                return o2.play - o1.play;
            }
            // 제일 많이 플레이된 장르가 앞에 오도록 내림차순
            return genrePlayCount.get(o2.genre) - genrePlayCount.get(o1.genre);
        });

        // 장르별로 상위 최대 두 개씩 출력하고, 나머지는 전부 건너뛴다. 
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> genreAddedCount = new HashMap<>();

        for (Music music : playList) {
            if (genreAddedCount.getOrDefault(music.genre, 0) < 2) {
                answerList.add(music.num);
                genreAddedCount.put(music.genre, genreAddedCount.getOrDefault(music.genre, 0) + 1);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

class Music {
    int num;        // 고유 번호
    String genre;   // 장르
    int play;       // 플레이 횟수
    
    public Music(int num, String genre, int play) {
        this.num = num;
        this.genre = genre;
        this.play = play;
    }
}
