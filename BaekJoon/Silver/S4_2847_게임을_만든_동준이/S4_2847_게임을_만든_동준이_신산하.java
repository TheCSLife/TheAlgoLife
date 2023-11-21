// 메모리 : 12948KB
// 시간 : 128ms

package BaekJoon.Silver;


import java.util.Scanner;

public class S4_2847_게임을_만든_동준이_신산하 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int level_count = sc.nextInt();
        int[] scoreList = new int[level_count];
        int keep_num = 0;

        for(int i=0;i<level_count;i++){
            scoreList[i] = sc.nextInt();
        }

        //입력 끝


        //1. 마지막 점수 keep
        keep_num = scoreList[level_count-1];

        //2. 제거할 점수 체크
        int result = 0;

        for(int i=level_count-2; i>=0; i--){

            if(scoreList[i]==keep_num-1){
                keep_num--;
            }

            else if(scoreList[i]>keep_num-1){
                result+=scoreList[i] - (keep_num-1);
                keep_num--;
            }

            else if(scoreList[i]<keep_num-1){
                keep_num = scoreList[i];
            }

        }

        System.out.println(result);

    }
}
