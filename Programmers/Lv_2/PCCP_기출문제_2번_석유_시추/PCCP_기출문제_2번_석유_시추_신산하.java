package Programmers.JAVA.Lv_2;

import java.util.LinkedList;
import java.util.Queue;

public class PCCP_기출문제_2번_석유_시추_신산하 {
    static boolean[][] visited;
    static int[] colOilCount;
    
    static int[][] drc = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    static int maxOil = 0;
    
    public int solution(int[][] land) {
        
        int rowCount = land.length;
        int colCount = land[0].length;
        
        visited = new boolean[rowCount][colCount];
        colOilCount = new int[colCount];
        
        
        //1. 땅의 갯수와 해당 땅의 석유 수 구하기
        int count = 1;
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                if(land[i][j]==1 && !visited[i][j]){
                    BFS(land, i, j, count);
                    count++;
                }
            }
        }

        
        //2. 결과 도출
        return maxOil;
    }
    
    public static void BFS(int[][] land, int startR, int startC, int no){
        
        Queue<Node> q = new LinkedList<>();
        int size = 0;
        boolean[] colVisit = new boolean[land[0].length];
        
        //첫 노드 넣기
        q.offer(new Node(startR, startC));
        visited[startR][startC] = true;
        
        while(!q.isEmpty()){
            
            Node curNode = q.poll();
            size++;
            land[curNode.r][curNode.c] = no;
            colVisit[curNode.c] = true;
            
            for(int d=0; d<4; d++){
                int nextR = curNode.r+drc[d][0];
                int nextC = curNode.c+drc[d][1];
                
                if(nextR<0 || nextR>=land.length || nextC<0 || nextC>=land[0].length)
                    continue;
                if(land[nextR][nextC]==0 || visited[nextR][nextC]) continue;
                
                q.offer(new Node(nextR, nextC));
                visited[nextR][nextC] = true;
                
            }
            
        }
        
        for(int i=0;i<land[0].length;i++){
            if(colVisit[i]){
                colOilCount[i] += size;
                maxOil = Math.max(maxOil, colOilCount[i]);
            }
        }
        
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
