//
// author: Abdelaziz EROUI
//
#include <bits/stdc++.h>

using namespace std;

int main()
{
  int n, m;
  cin >> n >> m;
  char arr[n][m];
  int dist[n][m];
  int MAXVALUE = (int)1e9;

  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
    for (int j = 0; j < m; ++j)
    {
      dist[i][j] = 0;

      if (arr[i][j] == 'o')
      {
        dist[i][j] = MAXVALUE;
      }
    }
  }

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < m; ++j)
      if (arr[i][j] == 'x')
      {
        queue<pair<pair<int, int>, int>> q;
        q.push(make_pair(make_pair(i, j), 0));

        while (!q.empty())
        {
          pair<pair<int, int>, int> p = q.front();
          q.pop();
          pair<int, int> pp = p.first;
          int u = pp.first;
          int v = pp.second;
          int d = p.second;

          if (dist[u][v] < d)
            continue;
          dist[u][v] = d;

          for (int dx = -1; dx <= 1; ++dx)
          {
            for (int dy = -1; dy <= 1; ++dy)
            {
              if (abs(dx) == abs(dy))
                continue;
              if (u + dx < 0 || u + dx >= n)
                continue;
              if (v + dy < 0 || v + dy >= m)
                continue;
              if (arr[u + dx][v + dy] == '.')
                continue;

              q.push(make_pair(make_pair(u + dx, v + dy), d + 1));
            }
          }
        }
      }
  }

  int days;
  cin >> days;
  int ans = 0;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < m; ++j)
    {
      if (dist[i][j] > days)
        ++ans;
    }
  }

  cout << ans << endl;
  return 0;
}
