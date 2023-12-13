/*
* Memory : 12812 KB
* Time : 112 ms
* */

package BaekJoon.Gold;

import java.io.*;

public class G5_15989_1_2_3_더하기_4_신산하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        //10억 + 10억 + 10억 = 30억 -> 오버플로우
        //[10001][10001] -> heap 영역 오버
        long[][] dp = new long[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        for(int i=4;i<10001;i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int T=1;T<=t;T++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num][1]+dp[num][2]+dp[num][3]);
        }
    }
}
