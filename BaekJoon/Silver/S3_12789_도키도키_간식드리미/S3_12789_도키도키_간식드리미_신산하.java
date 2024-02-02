/*
* Memory : 11812 KB
* Time : 88 ms
* */

//1. 대기하러 가거나 vs 받으러 가거나
//2. 대기줄에서 받을 수 있는 사람 있는지 확인
//3. 통로에서 자기순서면 간식 받으러 가기
//4. 자기순서가 아니면 대기하기
//  - 대기줄이 비어 있으면 바로 go
//  - 대기줄이 비어있지 않으면 대기 top보다 작은거면 go
//    - 근데 크면 대기줄에서 order 빠져나갈 수 있는지 확인
//5. 두 조건에 모두 성립되지 않는다면 "Sad"
//6. order가 N까지 모두 나왔다면 "Nice"

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

public class S3_12789_도키도키_간식드리미_신산하 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String info = br.readLine();
    StringTokenizer st = new StringTokenizer(info, " ");

    Stack<Integer> ready = new Stack<>();
    int order = 1;// 받을 차례

    boolean flag = true;
    for (int i = 0; i < N; i++) {

      // 대기줄에서 받을 수 있는지 확인
      while (!ready.isEmpty() && ready.peek() == order) {
        ready.pop();
        order++;
      }

      int next = Integer.parseInt(st.nextToken());
      if (order == next)
        order++; // 통로에서 받을 수 있는지 확인
      else if (ready.isEmpty() || ready.peek() > next)
        ready.add(next);
      else {
        flag = false;
        break;
      }
    }

    if (flag)
      System.out.println("Nice");
    else
      System.out.println("Sad");
  }
}
