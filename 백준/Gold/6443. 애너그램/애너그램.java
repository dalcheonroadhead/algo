import java.util.*;
import java.io.*;

public class Main {
    static int [] alphabet;
    static StringBuilder ans = new StringBuilder ();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++){
            String word = br.readLine();
            alphabet = new int [26];
            
            for(int j = 0; j < word.length(); j++){
                alphabet[word.charAt(j) - 'a']++;
            }
            permutation(0, new char [word.length()], alphabet);
        }

        System.out.println(ans.toString());
    }

    public static void permutation(int depth, char [] answer, int [] alphabet) {
        if(depth == answer.length){
            ans.append(String.valueOf(answer)).append("\n");
            return;
        }
        
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == 0) continue;
            
            alphabet[i]--;
            answer[depth] = (char)(i + 'a');
            permutation(depth+1, answer, alphabet);
            alphabet[i]++;
        }
        
    }
}