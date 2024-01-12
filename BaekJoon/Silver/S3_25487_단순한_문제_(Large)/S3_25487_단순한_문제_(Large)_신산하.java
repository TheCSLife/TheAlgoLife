/*
* Memory : 218472 KB
* Time : 744 ms
* */

package BaekJoon.Silver;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S3_25487_단순한_문제_(Large)_신산하{
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int T=1;T<=t;T++){
        String abc = br.readLine();
        StringTokenizer st = new StringTokenizer(abc," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int min = Math.min(a,(Math.min(b,c)));

        sb.append(min).append("\n");
        
    }//for T

    System.out.println(sb);
    br.close();
  }
}
