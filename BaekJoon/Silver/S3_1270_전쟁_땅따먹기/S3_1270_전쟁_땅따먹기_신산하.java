/*
* Memory : 315804 KB
* Time : 4724 ms
* */

package BaekJoon.Silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

public class S3_1270_전쟁_땅따먹기_신산하 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
        
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      String tNum = br.readLine();
      StringTokenizer st = new StringTokenizer(tNum, " ");
      long t = Long.parseLong(st.nextToken());

      HashMap<Long, Integer> area = new HashMap<>();
      boolean flag = false;
        
      for (int j = 0; j < t; j++) {
        long teamNumber = Long.parseLong(st.nextToken());
        area.put(teamNumber, area.getOrDefault(teamNumber, 0) + 1);

        if (area.get(teamNumber) > t/2) {// 절반 넘음
          sb.append(teamNumber).append("\n");
          flag = true;
          break;
        }
      }

      if (!flag){
        sb.append("SYJKGW").append("\n");
      }
    } // for end

    System.out.println(sb);
  }
}
