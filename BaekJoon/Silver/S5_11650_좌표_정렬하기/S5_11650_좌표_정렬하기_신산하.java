/*
* Memory : 182584KB
* Time : 2444ms
* */

package BaekJoon.Silver;

import java.util.Scanner;
import java.util.PriorityQueue;

public class S5_11650_좌표_정렬하기_신산하 {

    static PriorityQueue<Point> points = new PriorityQueue<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        for(int i=0;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        //입력끝 정렬끝

        for(int i=0;i<N;i++){
            Point point = points.poll();
            System.out.println(point.x+ " " + point.y);
        }
        
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o){
            if(this.x==o.x){
                return this.y>o.y?1:-1;
            }
            else{
                return this.x>o.x?1:-1;
            }
        }
    }
}
