/*
* Memory : 12416 KB
* Time : 104 ms
* */

package BaekJoon.Gold;

import java.util.*;
import java.io.*;

//   2 5 7 1 3 4 8  6  9  3
// 0 0 3 5 9 9 10 14 14 17 20

public class G5_2229_조_짜기_신산하 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String numbers = br.readLine();
    StringTokenizer st = new StringTokenizer(numbers, " ");

    int[] score = new int[N + 1];
    int[] dp = new int[N + 1];
    dp[0] = 0;
    int max = 0;
    for (int i = 1; i <= N; i++) {
      score[i] = Integer.parseInt(st.nextToken());
      for (int j = i - 1; j >= 1; j--) {
        max = Math.max(max, Math.abs(score[i] - score[j]) + dp[j - 1]);
      }
      dp[i] = max;
    }

    System.out.println(dp[N]);
  }

}
