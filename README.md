# Girls Code 2019 Editorial

- in this repository you'll find:
  - PDF problem statement
  - Editorial and overview of the problems
  - Setters solutions

## Problem A : High school mathematics
## Setter: Moncef MHASNI
### Difficulty: Medium

- This problem was one of those problems that "either you know the concept/idea/theorem or either you don't", if you've practiced enough `number theory` problems you absolutely
 will come across 'Euler totient function` which is the direct answer to this problem . here is a [link](https://cp-algorithms.com/algebra/phi-function.html) explaining the concept .

## Problem B : Rotten Berries
### Setter: Azuz ERRAOUI
### Difficulty: Medium

- As the problem states you are given a 2D grid, with healthy and rotten berries, and the problem is to find out what is the number of healthy berries is going to be left after D days,
 while knowing that each day a rotten berry will transform all of it's helthy neighbours to rotten berries as well . one might make the problem easier by looking at it this way:
 w#hat is the minimum number of days for a berry to be transformed to be rotten . by looking at it this way we can just do a multi-source `bfs` and find for each healthy berry the closest rotten one,
 and after that we can just check if the minimum time is bigger that or equal to D, and that solves the problem .

- Note that some contestants tried to do a simulation of the process, by doing the transformation for all the given days . but that's not enough to solve the problem and it give a `TLE` verdict .

## Problem C : Unique Substring
### Setter: Azuz ERRAOUI
### Difficulty: Easy

- The problem asks that given a string `s` with lowercase english characters, remove all duplicate characters while keeping their order in the original string, let's call it string `s'`, `s'` should be the smallest lexicographicaly
possible string of all solutions .
- This can be done by following a simple greedy approach, count the occurences of the characters in the original string, and for every character from `z` to `a` if it's possible to remove the current character from the string
i.e `occ[a[i]] > 1` then we remove it, and that way we grantee that the resulting string is smallest as possible .
- other approaches to solving this problem can be found in the setters solution .

## Problem D : Last digit
### Setter: Azuz ERRAOUI
### Difficulty: Easy

- This one is an easy one, the trick here is to observe that factorial 5! can be written as `5! = 1 * 2 * 3 * 4 * 5` or
`5! = 1 * 5 * 2 * 3 * 4` or `5! = 1 * 10 * 3 * 4` and anything times `10` must have `0` as it's last digit so the solution is if `N` is less than or equal to
`4` compute factorial and print the last digit, otherwise just print `0`.

## Problem E : Tree Puzzle
### Setter: Mouad NACIRI
### Difficulty: Medium

- This problem required to print the sum of the values of all nodes at even level from the root which is always `1`, the solution can be done by either `bfs` or `dfs`,
starting from the root keep track of the current level and a global sum and only add those where the `level % 2 == 0` .

## Problem F : Stable zeroing
### Setter: Azuz ERAOUI
### Difficulty: Easy

- This problem is self explanatory, take a list when reading the input, if the element is none zero push it to the list or else ignore it, then print the list .
- Note: some of the common mistakes with this problem is that it required strict formatting, so trailing spaces were not tolerated, and many contestants got a `WA` verdict

## Problem G : Azuz's Anagram
### Setter: Mouad NACIRI
### Difficulty: Easy

- This problem also is easy, you just need a function `bool is_anagram(string first, string second)` to test if two strings are anagrams,
this can be done by various ways : (sorting both, counting occurences) and printing the result according to the statement .

## Problem H : Houda and Weird Auction
### Setter: Mehdi CHERACHER
### Difficulty: Medium

- To solve this problem, you need to extract the operations you need to get the answer for each day :
  - you need to find the `min` of the current box
  - you need to find the `max` of the current box
  - you need to add to the box
  - you need to delete from the box
and all those operations should be done efficiently, so you need a data structure that has fast `delete`, `add` operations, and has ordering included and also can support having
multiple occurrences of the same element, and this can be solved with `multiset<t>` in c++ or `TreeMap<T, Integer>` in java, check the setters solution for more clarity .

## Problem I : Oola and the Rabbits
### Setter: Achraf MAMDOUH
### Difficulty: Medium

- Given a graph you need to find the longest shortest path in it, this problem would've been harder if the size of the graph was bigger ,
but here we must note that `N <= 50` so a solution of the order `O(N^3)` will work fine, to find this let us compute the all pair shortest paths using
floyd warshall's algorithm, and let's pick the longest one .
- Another approach if you don't know floyd's algorithm is just to do a bfs for every pair of nodes to determine the shortest distance between them, as the graph is small enough this solution will also pass.

## Problem J : Houda Playing Poker
## Setter: Mehdi CHERACHER
## Difficulty: Medium

- The problem essentiely asks us to find the the subarray with the largest positive sum, if the input only contained positive values, the solution is the whole array .
The twist here is that the values might be negative which impacts the optimal final answer. to answer this we will use `dynamic programming` using this recurrence :
```
  f(i) = max(
    f(i - 1),
    f(i - 1) + arr[i]
  )
```
- This problem is quite classical, lookup `kadane's algorithm` for more info .
