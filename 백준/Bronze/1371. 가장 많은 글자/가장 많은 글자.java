import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static int [] alphabet = new int [26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == ' ') continue;
                alphabet[line.charAt(i) - 'a']++;
            }
        }

        int ans_value = 0;
        for (int i = 0; i < 26; i++) {
            if(ans_value < alphabet[i]) {
                ans_value = alphabet[i];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(alphabet[i] == ans_value) ans.append((char)(i + 'a'));
        }
        System.out.println(ans);
    }
}
