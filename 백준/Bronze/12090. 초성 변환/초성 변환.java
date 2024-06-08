import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final char[] CHOSEUNG = {
      'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ','ㅅ','ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(getChoseong(s.charAt(i)));
        }

        System.out.println(sb);
    }

    public static char getChoseong(char hangul) {
        int unicodeValue = hangul - 0xAC00;
        int choseongIndex = unicodeValue/(21*28);
        return CHOSEUNG[choseongIndex];
    }
}