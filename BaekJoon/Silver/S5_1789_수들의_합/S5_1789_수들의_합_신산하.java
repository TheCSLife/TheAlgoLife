/*
* Memory : 12872 KB
* Time : 112 ms
* */

package BaekJoon.Silver;

public class S5_1789_수들의_합_신산하 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long S = sc.nextLong();

    long sum = 0;
    int i = 1;
    while (sum <= S) {
      sum += i++;
    }

    System.out.println(i - 2);

  }

}
