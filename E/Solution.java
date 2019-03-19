import java.util.*;
import java.io.*;

/**
 * @author Abdelaziz EROUI
 */
public class Solution {

  private static ArrayList<Integer>[] adjList;
  private static int[] value;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    value = new int[N + 1];
    adjList = new ArrayList[N + 1];
    for (int i = 1; i <= N; ++i) {
      value[i] = in.nextInt();
      adjList[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; ++i) {
      int u = in.nextInt();
      int v = in.nextInt();

      adjList[u].add(v);
      adjList[v].add(u);
    }

    System.out.println(dfs(1, false, 0));
  }

  private static long dfs(int u, boolean evenLevel, int parent) {
    long ret = 0;

    if (evenLevel) {
      ret += value[u];
    }

    for (int v : adjList[u])
      if (v != parent) {
        ret += dfs(v, !evenLevel, u);
      }

    return ret;
  }

}
