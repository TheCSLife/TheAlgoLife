/*
* Memory : 11632 KB
* Time : 80 ms
* */

//1. 한줄 입력 받고
//2. char 하나씩 보면서 빈칸 세기 -> 2개이상 -> row + 1
//3. col 방향으로 char 하나씩 보면서 빈칸 세기 -> 2개 이상 -> col + 1 -> break;
//4. 결과 출력
// 주의 : 한 줄에 1번 이상 누울 자리가 생길 수 있음

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

public class S5_1652_누울_자리를_찾아라_신산하 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    char[][] map = new char[N][N];
    int row = 0;
    int col = 0;
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      int blank = 0;
      for (int j = 0; j < N; j++) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == '.') {
          blank++;
          if (blank == 2)
            row++;
        } else
          blank = 0;
      }
    } // for end

    // 입력 끝

    for (int c = 0; c < N; c++) {
      int blank = 0;
      for (int r = 0; r < N; r++) {
        if (map[r][c] == '.') {
          blank++;
          if (blank == 2)
            col++;
        } else
          blank = 0;
      }
    }

    System.out.println(row + " " + col);
  }
}
