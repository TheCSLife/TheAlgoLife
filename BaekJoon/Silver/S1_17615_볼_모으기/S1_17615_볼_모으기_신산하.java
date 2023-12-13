/*
* Memory : 17732 KB
* Time : 204 ms
* */

package BaekJoon.Silver;

import java.util.*;
import java.io.*;

public class S1_17615_볼_모으기_신산하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        boolean turn = false;
        char endColor = balls.charAt(balls.length()-1);
        int endChange = 0; //위치 바꿔야할 공은 몇 개?
        int ballCount = 0; //맨 끝 공과 같은 색 공은 몇 개?

        //1. 뒤 기준으로 판단
        for(int i=balls.length()-1;i>=0;i--){
            if(endColor != balls.charAt(i)) turn = true;
            if(endColor == balls.charAt(i)){
                ballCount++;
                if(turn) endChange++;
            }
        }

        int anotherBallChange = balls.length()-ballCount;
        endChange = Math.min(endChange, anotherBallChange);

        //2. 앞 기준으로 판단
        turn = false;
        char frontColor = balls.charAt(0);
        int frontChange = 0; //위치 바꿔야할 공은 몇 개?
        ballCount = 0; //맨 처음 공과 같은 색 공은 몇 개?
        
        for(int i=0;i<balls.length();i++){
            if(frontColor != balls.charAt(i)) turn = true;
            if(frontColor == balls.charAt(i) && turn) frontChange++;
        }

        anotherBallChange = balls.length()-ballCount;
        frontChange = Math.min(frontChange, anotherBallChange);

        System.out.println(Math.min(endChange, frontChange));
    }
}
