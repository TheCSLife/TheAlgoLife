/*
* Memory : 34848KB
* Time: 1940ms
* */

package BaekJoon.Gold;

import java.util.*;

public class G5_6443_애너그램_신산하 {

    static char[] word;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int T=1;T<=t;T++){
            word = sc.next().toCharArray();
            Arrays.sort(word);
            
            do{
                System.out.println(word);
            }while(NextPermutation());
        }
        
    }

    public static boolean NextPermutation(){
        int idx_a = word.length-1;
        while(idx_a>0 && word[idx_a-1]>=word[idx_a])idx_a--;
        if(idx_a==0) return false;

        int idx_b = word.length-1;
        while(word[idx_a-1]>=word[idx_b])idx_b--;
        Swap(idx_a-1, idx_b);

        int idx_k = word.length-1;
        while(idx_a<idx_k) Swap(idx_a++, idx_k--);
        
        return true;
    }

    public static void Swap(int idx_a, int idx_b){
        char term = word[idx_a];
        word[idx_a] = word[idx_b];
        word[idx_b] = term;
    }
}
