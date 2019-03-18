import java.util.*;
import java.io.*;

/**
 * @author Azuz Eraoui
 */
public class Main {

  private static int[] ans = { 1, 1, 2, 6, 4, 0 };

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while (T-- > 0) {
      System.out.println(ans[Math.min(in.nextInt(), 5)]);
    }
  }
}
