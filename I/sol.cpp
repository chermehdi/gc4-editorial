//
// author: Achraf Mamdouh
//
#include <cstdio>
#include <algorithm>

using namespace std;

const int kInfinity = 12345;

int main(void)
{
  int num_rabbits, num_edges;
  scanf("%i %i", &num_rabbits, &num_edges);

  int friendship_distance[num_rabbits][num_rabbits];
  for (int i = 0; i < num_rabbits; i++)
  {
    for (int j = 0; j < num_rabbits; j++)
    {
      friendship_distance[i][j] = kInfinity;
    }
    friendship_distance[i][i] = 0;
  }

  for (int i = 0; i < num_edges; i++)
  {
    int a, b;
    scanf("%i %i", &a, &b);
    friendship_distance[a][b] = 1;
    friendship_distance[b][a] = 1;
  }

  for (int k = 0; k < num_rabbits; k++)
  {
    for (int i = 0; i < num_rabbits; i++)
    {
      for (int j = 0; j < num_rabbits; j++)
      {
        friendship_distance[i][j] =
            min(friendship_distance[i][j],
                friendship_distance[i][k] + friendship_distance[k][j]);
      }
    }
  }

  int diameter = 0;
  for (int i = 0; i < num_rabbits; i++)
  {
    for (int j = i + 1; j < num_rabbits; j++)
    {
      diameter = max(diameter, friendship_distance[i][j]);
    }
  }

  printf("%i\n", diameter);

  return 0;
}
