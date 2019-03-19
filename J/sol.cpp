//
// author Abdelaziz EROUI
//
#include <bits/stdc++.h>

using namespace std;

int main()
{
  int t;
  cin >> t;
  while (t--)
  {
    int n, x;
    cin >> n;
    int ans = 0, cur = 0;

    for (int i = 0; i < n; ++i)
    {
      cin >> x;
      cur += x;
      ans = max(ans, cur);
      cur = max(cur, 0);
    }

    if (ans <= 0)
    {
      cout << "better luck next year" << endl;
    }
    else
    {
      cout << ans << endl;
    }
  }
  return 0;
}
