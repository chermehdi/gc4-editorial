import java.util.*;
import java.io.*;

/**
 * @author Azuz Eraoui
 */
public class Solution {

  private static int[] dx = { 1, -1, 0, 0 };
  private static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();

    char[][] arr = new char[n][m];
    int[][] time = new int[n][m];
    for (int i = 0; i < n; ++i) {
      arr[i] = in.next().toCharArray();

      for (int j = 0; j < m; ++j) {
        time[i][j] = Integer.MAX_VALUE;
        if (arr[i][j] == 'x') {
          time[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j)
        if (arr[i][j] == 'x') {

          ArrayDeque<Pair> q = new ArrayDeque<>();
          q.offer(new Pair(i, j, 0));

          while (!q.isEmpty()) {
            Pair p = q.poll();

            if (time[p.f][p.s] < p.time)
              continue;

            time[p.f][p.s] = p.time;
            for (int ii = 0; ii < dx.length; ++ii) {
              int x = p.f + dx[ii];
              int y = p.s + dy[ii];

              if (x < 0 || y < 0 || x >= n || y >= m) {
                continue;
              }

              if (arr[x][y] == '.')
                continue;
              q.offer(new Pair(x, y, p.time + 1));
            }
          }

        }
    }

    int d = in.nextInt();
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (arr[i][j] == 'o' && time[i][j] > d) {
          ++ans;
        }
      }
    }

    System.out.println(ans);

  }

  private static class Pair {
    int f, s;
    int time;

    public Pair(int f, int s, int time) {
      this.f = f;
      this.s = s;
      this.time = time;
    }
  }
}
