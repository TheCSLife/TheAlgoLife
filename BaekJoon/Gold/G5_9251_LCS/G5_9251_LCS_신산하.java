/*
* Memory : 16208 KB
* Time: 116 ms
* */

package BaekJoon.Gold;

import java.util.*;
import java.io.*;

//0.4초
//LCS
public class G5_9251_LCS_신산하 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();

    int str1Len = str1.length();
    int str2Len = str2.length();

    int dp[][] = new int[str2Len+1][str1Len+1];
    for(int i=1;i<=str1Len;i++){
        for(int j=1;j<=str2Len;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){//charAt은 0부터 시작 주의
                dp[j][i] = dp[j-1][i-1]+1;
            }
            else{
                dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
            }
        }
    }
    System.out.println(dp[str2Len][str1Len]);
  }
}
