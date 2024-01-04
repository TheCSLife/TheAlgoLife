/*
* Memory : 98124 KB
* Time: 400 ms
* */

package BaekJoon.Gold;

import java.util.*;
import java.io.*;

public class G5_11729_하노이_탑_이동_순서_신산하 {
  static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((int)(Math.pow(2,N)-1)).append("\n");
        
        
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int N, int start, int mid, int to){
        if(N==1){
            sb.append(start+" "+to).append("\n");
            return;
        }

        //step1 : start -> mid
        hanoi(N-1, start, to, mid);

        //step2 : start -> end (가장 큰 수)
        sb.append(start+" "+to).append("\n");

        //step3: mid -> to (나머지 원반 모두 옮기기)
        hanoi(N-1, mid, start, to);
    }
}
