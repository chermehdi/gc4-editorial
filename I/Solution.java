import java.util.*;
import java.io.*;

/**
 * @author Abdelaziz EROUI
 */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    int M = in.nextInt();

    int[][] dist = new int[N + 1][N + 1];
    for (int i = 0; i < N; ++i) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
      dist[i][i] = 0;
    }
    for (int i = 0; i < M; ++i) {
      int u = in.nextInt();
      int v = in.nextInt();
      dist[u][v] = dist[v][u] = 1;
    }

    int maxValue = 0;
    for (int k = 0; k < N; ++k) {
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          if (dist[i][k] != Integer.MAX_VALUE && dist[j][k] != Integer.MAX_VALUE) {
            dist[i][j] = dist[j][i] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
    }

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        maxValue = Math.max(maxValue, dist[i][j]);
      }
    }

    System.out.println(maxValue);
  }

}
