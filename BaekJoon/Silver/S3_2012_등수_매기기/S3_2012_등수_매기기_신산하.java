/*
* Memory : 56648 KB
* Time : 648 ms
* */

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

//등수 순대로 순위를 매긴다.
//50만이라는 등수가 50만번 나올 수 있음

public class S3_2012_등수_매기기_신산하 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < count; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    int order = 1;
    long total = 0;
    while (!pq.isEmpty()) {
      int cur = pq.poll();
      total += Math.abs(cur - order);
      order++;
    }

    System.out.println(total);
  }
}
