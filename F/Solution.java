import java.util.*;
import java.io.*;

/**
 * @author Abdelaziz EROUI
 */
public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long[] arr = new long[n];
    for (int i = 0; i < n; ++i) {
      arr[i] = in.nextLong();
    }

    int j = 0;
    for (int i = 0; i < n; ++i) {
      if (arr[i] != 0) {
        arr[j] = arr[i];
        ++j;
      }
    }

    while (j < n) {
      arr[j] = 0;
      ++j;
    }

    for (int i = 0; i < n; ++i) {
      if (i > 0)
        System.out.print("  ");
      System.out.print(arr[i]);
    }
  }
}
