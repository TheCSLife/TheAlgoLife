/*
* Memory : 297308 KB
* Time : 1176 ms
* */

package BaekJoon.Gold;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class G4_2573_빙산_신산하 {
    static boolean[][] visited;
    static int[][] drc = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n;
    static int m;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력
        String n_m = br.readLine();
        StringTokenizer st = new StringTokenizer(n_m, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0;i<n;i++){
            String numLine = br.readLine();
            st = new StringTokenizer(numLine, " ");

            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// for end


        //2. 빙하 깎기
        int year = 0;
        int count = 1; //빙하 수

        while(count==1){
            visited = new boolean[n][m];
            melting:for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==0 && !visited[i][j]){
                        BFS(i, j);
                    }
                }
            }// melting end
            year++;

            //check seperate
            //빙하가 부숴졌냐? BFS
            count = 0;
            visited = new boolean[n][m];
            check:for(int a=0;a<n;a++){
                for(int b=0;b<m;b++){
                    if(map[a][b]>0 && !visited[a][b]){
                        if(count>1){
                            break check;
                        }
                        else{
                            Seperate(a,b);
                            count++;
                        }
                    }
                    
                }
            } // for a end
        }

        if(count==0) System.out.println(0);
        else System.out.println(year);
    }

    //빙하 깎기
    public static void BFS(int startR, int startC){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC));
        visited[startR][startC] = true;

        while(!q.isEmpty()){
            Node curNode = q.poll();

            for(int d=0;d<4;d++){
                int nextR = curNode.r+drc[d][0];
                int nextC = curNode.c+drc[d][1];

                if(nextR<0 || nextR>=n || nextC<0 || nextC>=m) continue;
                if(visited[nextR][nextC]) continue;

                if(map[nextR][nextC]>0){
                    map[nextR][nextC]--;
                    if(map[nextR][nextC]==0) visited[nextR][nextC] = true;
                }

                else if(map[nextR][nextC]==0){
                    visited[nextR][nextC] = true;
                    q.offer(new Node(nextR, nextC));
                }
                
            }// for d end
            
        }// while end
    }

    //빙하가 두동강 났니?
    public static void Seperate(int startR, int startC){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC));
        visited[startR][startC] = true;

        while(!q.isEmpty()){
            Node curNode = q.poll();

            for(int d=0;d<4;d++){
                int nextR = curNode.r+drc[d][0];
                int nextC = curNode.c+drc[d][1];

                if(nextR<0 || nextR>=n || nextC<0 || nextC>=m) continue;
                if(visited[nextR][nextC]) continue;

                if(map[nextR][nextC]>0){
                    visited[nextR][nextC] = true;
                    q.offer(new Node(nextR, nextC));
                }
                
            }// for d end
            
        }// while end
    }
    
    public static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
