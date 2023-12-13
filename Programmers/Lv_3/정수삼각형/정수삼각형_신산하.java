//무조건 삼각형

public class 정수삼각형_신산하 {
    public int solution(int[][] triangle) {
        
        int r = triangle.length;
        int c = triangle[r-1].length;
        
        int[][] dp = new int[r][c];
        dp[0][0] = triangle[0][0];
        
        for(int i=0;i<r-1;i++){
            for(int j=0;j<triangle[i].length;j++){
                int leftC = j;
                int rightC = j+1;
               
                //좌측 dp 구하기
                int newLeftNum = triangle[i+1][leftC] + dp[i][j];
                dp[i+1][leftC] = Math.max(dp[i+1][leftC], newLeftNum);
                
                //우측 dp 구하기
                int newRightNum = triangle[i+1][rightC] + dp[i][j];
                dp[i+1][rightC] = Math.max(dp[i+1][rightC], newRightNum);
            }
        }//i for end
        
        //dp 마지막 줄에서 제일 큰 수가 정답
        int result = 0;
        for(int i=0;i<c;i++){
            result = Math.max(result,dp[r-1][i]);
        }
        
        return result;
    }
}
