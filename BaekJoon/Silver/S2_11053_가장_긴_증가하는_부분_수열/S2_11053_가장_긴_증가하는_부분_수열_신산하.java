/*
* Memory : 12208 KB
* Time : 100 ms
* */

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

public class S2_11053_가장_긴_증가하는_부분_수열_신산하 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String nums = br.readLine();
    StringTokenizer st = new StringTokenizer(nums, " ");
    int[] num = new int[N];
    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    // 입력 끝

    int[] dp = new int[N];
    int max = 1;
    Arrays.fill(dp, 1);
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (num[i] > num[j])
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
      if (max < dp[i])
        max = dp[i];
    }

    System.out.println(max);
  }
}
