/*
* Memory : 41832 KB
* Time : 360 ms
* */

package BaekJoon.Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_13305_주유소_신산하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] roadLen = new long[N-1];
        long[] oilPrice = new long[N];
        
        String lens = br.readLine();
        StringTokenizer st = new StringTokenizer(lens, " ");
        for(int i=0;i<N-1;i++){
            roadLen[i] = Long.parseLong(st.nextToken());
        }

        String prices = br.readLine();
        st = new StringTokenizer(prices, " ");
        for(int i=0;i<N;i++){
            oilPrice[i] = Long.parseLong(st.nextToken());
        }

        
        long minimumPrice = 1000000001;
        long result = 0;

        for(int i=0;i<N-1;i++){
            if(minimumPrice>oilPrice[i]){
                minimumPrice = oilPrice[i];
            }

            result+=roadLen[i]*minimumPrice;
        }

        System.out.println(result);

    }
}
