/*
* Memory : 33328 KB
* Time : 244 ms
* */

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

public class S1_15903_카드_합체_놀이_신산하 {
  static int N;
  static List<Long> card;

  public static void main(String[] args) throws Exception {
    // 카드수는 최대 1000개, 카드 숫자는 백만까지 나올 수 있음 -> long(카드, 결과)
    // 합체는 최대 15000번
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String NM = br.readLine();
    StringTokenizer st = new StringTokenizer(NM, " ");

    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String cards = br.readLine();
    st = new StringTokenizer(cards, " ");
    card = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      card.add(Long.parseLong(st.nextToken()));
    }

    // 입력 끝

    for (int i = 0; i < M; i++) {
      Collections.sort(card);

      long sum = card.get(0) + card.get(1);
      card.add(sum);
      card.add(sum);
      card.remove(0);
      card.remove(0);
    }

    // 3. 결과
    long sum = 0;
    for (int i = 0; i < N; i++) {
      sum += card.get(i);
    }

    System.out.println(sum);
  }
}
