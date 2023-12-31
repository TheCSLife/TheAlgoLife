import java.util.*;

//적을 상대하다가 우리팀이 -가 되었을 때 가장 큰 수의 적을 롤백 == pq
class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ourCount = n;
        int chance = k;
        int result = enemy.length;
        
        //if(enemy.length == k) return enemy.length; result = 0하고, 이게 들어가면 왜 틀리지?
        //아 애초에 for을 enemy.length까지만 돌고 result도 enemy.length까지만 나오네;;
        
        for(int level=0;level<enemy.length;level++){
            pq.offer(enemy[level]);
            ourCount-= enemy[level];
            
            if(ourCount<0){
                if(chance>0 && !pq.isEmpty()){
                    ourCount+= pq.poll();
                    chance--;
                }else{
                    //여기에 영원히 들어오지 않는다면 모든 적을 없앨 수 있다는 의미 result=0하면 안되는 이유
                    result = level;
                    break;
                }
            }
        }//for end
        
        return result;
    }
}
