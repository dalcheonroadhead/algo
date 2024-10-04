# 1. 문제 설명 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42895)

N과 number가 주어졌을 때, 사칙연산을 활용해 number를 나타낼 수 있는 N의 최소 개수를 구해라 

# 2. 접근 방식

## (1) 잘못 접근 했던 방식 

`KEY WORD`:  `BFS`

백준에서 자주 풀던 연산 규칙이 주어졌을 때, target 값을 몇 번만에 만들 수 있는지 구하는 문제라고 생각했다. 예를 들어 
`+2, x5 -1이 가능하다고 할 때, A를 B로 만드는 최소 경우 의수는?` 같은 문제 말이다. 
해당 문제는 

1. 문제의 최대 범위까지 1차원 배열을 만든다. (문제 범위가 1<= B <= 32000 배열의 크기는 32001)
   배열의 index는 숫자, value는 해당 숫자를 만들 수 있는 최소 연산 수 이다.
2. start 값인 A부터 시작해서, 연산을 활용해 다른 값 index로 이동한다. 
   만약 A = 2이면, 2로 만들 수 있는 다른 수는, 4, 10, 1 일 것이다. 이제 해당 수를 index로 가지는 원소의 value는 한 번의 연산으로 값을 구했음으로, 2가 된다.

![image-20241003140426954](../../../../Documents/GitHub/dalcheonroadhead-github-blog/dalcheonroadhead.github.io/images/프로그래머스_N으로표현/image-20241003140426954.png)

![image-20241003140520430](../../../../Documents/GitHub/dalcheonroadhead-github-blog/dalcheonroadhead.github.io/images/프로그래머스_N으로표현/image-20241003140520430.png)

### 해당 방식이 틀렸던 이유 

내가 예시로 들었던 문제에서는 해당 방식이 통한다. 이유는 `연산 방식과 피연산자가 고정되어 있기` 때문이다.
하지만 내가 풀어야 하는 N으로 표현에서는 상황이 다르다. `N = 5` 일 경우, `N= 1의 경우 중 하나` 와 `N=4의 경우 중 하나`, `N=2의 경우 중 하나` 와 `N=3의 경우 중 하나` 로  최소 횟수가 5인 수를 만드는 등 조합이 다양하기 때문이다. 이 때문에 위와 같이 배열로 문제를 푼다면, BFS 첫 wave에서 나온 수들을 다음 계산에서 또 찾아내서 모두 다시 계산에 활용 해야 한다. 탐색 시간 및 탐색한 값들에 대한 조합(O(2^n))으로 문제를 푸는 등 시간이 오래 걸린다. 

## (2) 제대로 된 풀이 방식

`KEY WORD`: `DP`

`DP는 똑똑한 완전 탐색`이라는 이명이 있는데, 해당 방법은 이 풀이 방식으로 풀더라도 경우의 수를 다 구하는 무식한 방법을 써서 정말 DP라고 불려도 되는지 모르겠다. 푸는 방식은 다음과 같다. 

1.  DP 배열을 만든다. 
   DP 배열은 `index` = 사용한 N의 개수, `value` = 해당 N의 개수로 만들 수 있는 모든 수를 set으로 저장 이다.
2. DP[1]은 당연히 N 자신밖에 없다.
3. DP[2]를 생각해본다면, `NN 문자열` 형식의 값 하나 + `N 2개 간의 사칙연산` 방식 일 것이다. 
4. DP[3]은 마찬가지로, `NNN 형식` 문자열 하나, `N=1` 와 `N=2`를 활용해 나올 수 있는 값일 것이다. 
   (**※ 주의점**: A +*/- B 일 때, `N=1`과 `N=2`를 양쪽 번갈아 사용해야한다. 왜냐하면, 빼기와 나누기의 경우 순서에 따라 값이 다르기 때문이다. 중복 값은 set이 걸러주니까 걱정말자.)
5. 이런 식으로 쭉 가면 DP[i]는 `N을 i번 이은 문자열` + `DP[i-k]`와 `DP[k]` 숫자들 간의 사칙연산 방식 일 것이다. 
   (1<= k < i)

N을 한 개 이용한 경우부터 차례대로 가는 것이기 때문에, 가장 최소의 N만 이용해서 숫자들을 만들어내고 있다. 따라서 값을 만들다가 target 값인 number가 나왔다면 거기서 loop를 종료하고 문제를 끝내면 된다. 
답의 값은 무조건 나온다. 왜냐하면 N/N이 1인 것을 이용하면, 1을 더하고 빼는 식으로 어떻게든 target값이 무엇이든지 만들 수 있기 때문이다. 

### 이런 풀이는 시간이 꽤 오래 걸릴 거 같은데 괜찮나요? 🤔

괜찮다. 이유는 다음 2가지 이유에서다. 

1. N=8 초과하여 계산되는 수는 모두 -1로 처리하라고 해서, 우리는 N=1부터 N=8까지만 처리하면 된다.
2. 계산해야할 양이 기하급수적이지 않다. 
   N = 1일 때, 계산 없음
   N = 2일 때, 4칙연산 4가지 + NN 해서 5개 
   N = 3 일 때, N=2(5가지) 와 N=1(1가지)에서 나온 값들 간의 사칙연산(20가지) + NNN 1개 
   ...

# 3. 코드 분석

 ```java
 import java.util.*;
 import java.io.*;
 
 class Solution {
     // 나누기를 통해 1을 만들 수 있기에, number가 1~ 32000 중 뭐든 간에 결국엔 만들 수 있다. 
     // 하지만 문제에서는 N 등장횟수가 8보다 크면 그냥 -1로 출력하라고 했다. 이 시점에서 N 등장횟수가 8번 이하인 녀석들만 계산하면 된다는 것이다. 
     
     /*
         dp[k] 는 N을 K번 사용한 값들의 모임 (dp 원소마다 set으로 값을 모아놓을 것임.)
         dp[k] 는 dp[l] 와 dp[k-l] 의 조합으로 나오는 모든 수 (1 <= l < k) 
     */
     public int solution(int N, int number) {
         if(N == number) return 1;
         // 0. 값 초기화
         Set<Integer> [] dp = new Set [9];
         for(int i = 1; i < 9; i++){
             dp[i] = new HashSet<>();
         }
         // 1. dp[1]부터 dp[8]까지 차근차근 계산 
         dp[1].add(N);
         int accN = N;
         for(int i = 2; i< 9; i++){
             accN = accN*10+N;
             if(accN == number) return i;
             dp[i].add(accN);
             
             for(int j = 1; j < i; j++){
                 for(int k : dp[j]){
                     for(int l : dp[i-j]){
                         int p = k+l; int s = k-l; int m = k*l; int d = l >0? k/l : 0;
                         if( p == number || s == number || m == number || d == number) return i;
                         dp[i].add(p);
                         dp[i].add(s);
                         dp[i].add(m);
                         if(d != 0) dp[i].add(d);
                     }
                 }
             }
         }
         return -1;
     }
 }
 ```

# 4. 잘못 접근 했던 코드

```java
import java.util.*;
import java.io.*;

class Solution {
    // all 배열: index = 숫자, value = 해당 숫자를  만들기 위해 쓰인 N의 최소 개수 
    // 생각해줘야 할 것: 
    //  1.N을 중복해서 적은 문자열을 활용하면 더 최소로 줄일 수 있는가? 
    //  2. 사칙연산과 N을 활용하면 더 최소로 줄일 수 있는가? 
    public int solution(int N, int number) {
        // 0. 값 초기화
        int [] all = new int [32001];
        Arrays.fill(all, Integer.MAX_VALUE);
        ArrayDeque<Integer> aq1 = new ArrayDeque<>();
        
        // 1. NN 형식 문자열을 활용하여, 만들 수 있는 숫자의 최소 횟수 구해서 queue에 넣기 -> 이걸로 사칙연산 활용
        int temp = N; 
        int c = 1;
        while(temp <= 32000){
            all[temp] = c++;
            aq1.add(temp);
            temp = temp*10+N;
        }
        
        // 2. 사칙연산과 N 활용하여 숫자 만드는 최소 횟수 구하기
        while(!aq1.isEmpty()){
            // nV = 숫자, nC = N으로 그 숫자를 만들 수 있는 횟수   
            int nV = aq1.poll();
            int nC = all[nV]; 
            int temp2 = N; 
            // N을 이어붙인 값들을 가지고 사칙연산해서 최소로 갈 수 있는 횟수를 셀거임
            while(temp2 <= 32000){
                // temp2 = N을 이어붙인 숫자 이걸로 사칙연산 GO
                for(int i = 0; i < 6; i++){
                    int now = 0;
                    switch(i) {
                        case 0: {now = nV + temp2; break;}
                        case 1: {now = nV - temp2; break;}
                        case 2: {now = nV * temp2; break;}
                        case 3: {now = nV / temp2; break;}
                        case 4: {now = temp2 - nV; break;}
                        case 5: {now = temp2 / nV; break;}
                    }
                    // now가 범위를 넘거나, now를 만든 횟수가 이미 있는 횟수보다 크면 넘어가기
                    if(now <= 0 || now > 32000 ||
                       temp2 > 32000 || temp2 < 0 || all[now] < nC + all[temp2]) continue; 
                    // 최소값 새로 갱신 했을  시에만 queue에 넣고 다시 계산 돌린다.
                    all[now] = nC + all[temp2];
                    aq1.add(now);
                }
                temp2 = temp2*10+N;
            }
        }
        return all[number] > 8? -1 : all[number];
    }
}
```

이전 N들을 활용한 조합을 통한 메모이제이션은 생각치 못했다.