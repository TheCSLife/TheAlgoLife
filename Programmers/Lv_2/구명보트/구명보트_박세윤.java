import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int boats = 0;
        
        Arrays.sort(people);
    
        int leftPointer = 0;
        int rightPointer = people.length - 1;
        
        while(true) {
            if(leftPointer >= rightPointer)
                break;
            
            if(people[leftPointer] + people[rightPointer] > limit)
                rightPointer--;
            else {
                leftPointer++;
                rightPointer--;
            }
            
            boats++;
        }
        
        if(leftPointer == rightPointer)
            boats++;
        
        return boats;
    }
}
