
//1. 입력 (while) -> .이 오면 끝 " ."이건 끝이 아님
//2. while 돌며 스택에 열린 괄호들 저장
//3. 닫힌 괄호들이 들어오면 스택에서 하나 꺼내서 짝 맞는지 확인
//4. 짝이 맞지 않거나 스택이 비어있으면 no -> 종료

/*
* Memory : 16544 KB
* Time : 176 ms
* */

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

public class S4_4949_균형잡힌_세상_신산하 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    while (true) {
      Stack<Character> open = new Stack<>();
      boolean flag = true;
      String line = br.readLine();
      if (line.equals("."))
        break;

      for (int i = 0; i < line.length(); i++) {
        char word = line.charAt(i);
        if (word == '[' || word == '(') {// 여는 괄호
          open.add(word);
        } else if (word == ']' || word == ')') {// 닫는 괄호
          if (open.isEmpty()) {// 비었음
            flag = false;
            break;
          }

          char cur = open.pop();
          if ((word == ']' && cur != '[') || (word == ')' && cur != '(')) {
            flag = false;
            break;
          }

        }
      } // for

      if (!flag)
        sb.append("no").append("\n");
      else {
        if (open.isEmpty()) {
          sb.append("yes").append("\n");
        } else {
          sb.append("no").append("\n");
        }
      }
    } // while

    System.out.println(sb);
  }
}