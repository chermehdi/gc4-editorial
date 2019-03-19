import java.util.*;
import java.io.*;

/**
 * @author Abdelaziz EROUI
 */
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] arr = in.next().toCharArray();
    int[] cnt = new int[26];
    boolean[] used = new boolean[26];

    for (char c : arr) {
      ++cnt[c - 'a'];
    }

    Stack<Character> stk = new Stack<>();
    for (char c : arr) {
      if (used[c - 'a']) {
        --cnt[c - 'a'];
        continue;
      }

      while (!stk.isEmpty()) {
        char cc = stk.peek();
        if (cc > c && cnt[cc - 'a'] > 0) {
          used[cc - 'a'] = false;
          stk.pop();
        } else
          break;
      }

      --cnt[c - 'a'];
      used[c - 'a'] = true;
      stk.push(c);
    }

    StringBuilder ans = new StringBuilder();
    while (!stk.isEmpty()) {
      ans.append(stk.pop());

    ans.reverse();
    System.out.println(ans.toString());
  }
}
