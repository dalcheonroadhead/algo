import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 1. main 태그 지우기 v
* 2. div 별로 구분 v
* 3. div에서 title 추출해서 출력 v
* 4. div 내부에 P태그 하나당 다음 과정 진행
*       (1) P 태그 내부의 모든 태그 지우기
*       (2) 문장 시작과 끝의 공백 지우기
*       (3) 공백 2개짜리는 하나로 바꾼다.
*       (4) P 태그 자체를 지우기
* */
/*
* 1. split으로 '<p>'로 구분하기
* 2. main은 버리기 div는 "\w+" 패턴으로 타이틀 제목 추출해서 출력
* 3. p 태그의 경우 위의 과정 그대로 하나씩 진행
* */
public class Main {
    static StringBuilder answer = new StringBuilder();
    static HashMap<Integer, String> location = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();
        Matcher title = Pattern.compile("<div title=\"(\\w|_|\\s)*\">").matcher(html);
        Matcher paragraph = Pattern.compile("<p>(\\w|\\s|</?[^p]>|</?\\w{2,}\\s?>|\\.)*</p>").matcher(html);

        while(title.find()) location.put(title.start(), "title : " + title.group().replaceAll("<div title=\"(.*)\">", "$1"));
        while (paragraph.find()){
            String row = paragraph.group();
            row = row.replaceAll("(</?\\w*\\s?>)", "");
            row = row.replaceAll("\\s{2,}", " ");
            row = row.trim();
            location.put(paragraph.start(), row);
        }

        ArrayList<Integer> keys = new ArrayList<>();
        for(int temp : location.keySet()){
            keys.add(temp);
        }
        Collections.sort(keys);

        for (int key : keys){
            answer.append(location.get(key)).append("\n");
        }

        System.out.println(answer);
    }
}
