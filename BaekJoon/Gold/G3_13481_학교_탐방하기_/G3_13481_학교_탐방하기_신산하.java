/*
* Memory : 165868 KB
* Time : 908 ms
* */

package BaekJoon.Gold;

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class G3_13481_학교_탐방하기_신산하 {
    static int N;
    static int M;
    static List<Edge> edgeList = new ArrayList<>();
    static int[] p;
    static int[] order;

    static int minR = 987654321;
    static int maxR = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");
        N = Integer.parseInt(st.nextToken());//건물의 수
        M = Integer.parseInt(st.nextToken());//도로의 수

        for(int i=0;i<M+1;i++){
            String info = br.readLine();
            st = new StringTokenizer(info, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int updown = Integer.parseInt(st.nextToken()); //0오르막길

            edgeList.add(new Edge(A, B, updown));
        }

        //입력 끝

        
        //오르막길이 가장 많은 루트
        p = new int[N+1];
        order = new int[N+1];
        setP();

        Collections.sort(edgeList, (e1, e2) -> e1.updown-e2.updown);

        int count = 0;
        
        for(int i=0; i<M+1; i++){
            Edge cur = edgeList.get(i);

            int startP = find(cur.start);
            int endP = find(cur.end);

            if(startP == endP) continue;

            union(cur.start, cur.end);

            if(cur.updown == 0) count++;
            
        }

        maxR = count*count;


        //내리막길이 가장 많은 루트
        p = new int[N+1];
        order = new int[N+1];
        setP();
        count = 0;
        
        for(int i=M; i>=0; i--){
            Edge cur = edgeList.get(i);

            int startP = find(cur.start);
            int endP = find(cur.end);

            if(startP == endP) continue;

            union(cur.start, cur.end);

            if(cur.updown == 0) count++;
            
        }

        minR = count*count;


        //결과
        System.out.println(maxR-minR);

    }

    public static void setP(){
        for(int i=0;i<N+1;i++){
            p[i] = i;
        }
    }

    public static int find(int target){
        if(target == p[target]) return target;
        return p[target] = find(p[target]);
    }

    public static void union(int a, int b){

        int ap = find(a);
        int bp = find(b);

        if(order[ap]>=order[bp]){
            order[ap]++;
            p[bp] = ap;
        }else{
            order[bp]++;
            p[ap] = bp;
        }
    }

    public static class Edge{
        int start;
        int end;
        int updown;

        public Edge(int start, int end, int updown){
            this.start = start;
            this.end = end;
            this.updown = updown;
        }
    }
}
