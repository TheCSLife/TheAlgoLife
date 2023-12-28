/*
* Memory : 15584 KB
* Time : 140 ms
* */

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

//1의 친구가 2 3 일 때
//3의 친구가 4가 있을 때
//1의 친구 조사하면서 3을 true로 해버리고, sel = true는 continue해버리면 4를 볼 수 없음
//막 continue하는 조건 넣지 말자는 오늘의 교훈
public class S2_5567_결혼식_신산하 {
  static List<Integer>[] friends;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    friends = new ArrayList[N + 1];// 1부터 시작
    for (int i = 0; i < N + 1; i++) {
      friends[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      String ab = br.readLine();
      StringTokenizer st = new StringTokenizer(ab, " ");

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      friends[a].add(b);
      friends[b].add(a);
    }

    int result = 0;
    boolean[] sel = new boolean[N + 1]; // 1부터 시작
    sel[1] = true; // 1은 주최자이기 때문에 포함 x

    for (int i = 0; i < friends[1].size(); i++) {// 친구

      int curF = friends[1].get(i);

      if (!sel[curF]) {
        result++;
        sel[curF] = true;
      }

      for (int j = 0; j < friends[curF].size(); j++) {// 친구의 친구
        int FF = friends[curF].get(j);

        if (!sel[FF]) {
          result++;
          sel[FF] = true;
        }
      }
    }

    System.out.println(result);
  }
}
