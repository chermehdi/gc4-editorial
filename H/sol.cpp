//
// author : Azuz Eraoui
//
#include <bits/stdc++.h>

using namespace std;

int main()
{

  int T;
  scanf("%d", &T);

  while (T--)
  {
    long long int ans = 0;
    map<int, int> mSet;
    int B, K;

    scanf("%d", &B);
    while (B--)
    {
      scanf("%d", &K);
      for (int i = 0, x; i < K; ++i)
      {
        scanf("%d", &x);
        ++mSet[x];
      }

      pair<int, int> min = *mSet.begin();
      pair<int, int> max = *mSet.rbegin();
      ans += (max.first - min.first);

      if (min.second == 1)
        mSet.erase(min.first);
      else
        --mSet[min.first];
      if (max.second == 1)
        mSet.erase(max.first);
      else
        --mSet[max.first];
    }

    printf("%lld\n", ans);
  }

  return 0;
}
