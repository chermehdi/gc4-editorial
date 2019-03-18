import java.util.*;



/**
 * @author Azuz Eraoui
 */
public class Solution {

  private static final String YES = "Awesome anagram";
  private static final String NO = "Azuz is not my leader";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while (T-- > 0) {
      char[] arr = in.next().toCharArray();
      char[] brr = in.next().toCharArray();

      if (arr.length == brr.length && arr[0] == brr[0] && arr[arr.length - 1] == brr[brr.length - 1]) {

        boolean ans = arr.length <= 2;
        for (int j = 1; j < brr.length - 1 && !ans; ++j) {
          int cur = j;
          boolean flag = true;
          for (int i = 1; i < arr.length - 1 && flag; ++i, ++cur) {
            if (cur == brr.length - 1) {
              cur = 1;
            }

            if (arr[i] != brr[cur]) {
              flag = false;
            }
          }

          ans = flag;
        }

        System.out.println(ans ? YES : NO);
      } else {
        System.out.println(NO);
      }
    }
  }

}
