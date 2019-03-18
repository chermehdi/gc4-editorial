package main

//
// author: Mouad Naciri
//

import (
	"bufio"
	"fmt"
	"os"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)

func printf(f string, a ...interface{}) { fmt.Fprintf(writer, f, a...) }
func scanf(f string, a ...interface{})  { fmt.Fscanf(reader, f, a...) }

var n int
var a []int
var t [][]int

func solve(u, p, l int) int64 {
  var cnt int64 = 0
  if l == 0 {
    cnt += int64(a[u - 1])
  }

  for _, v := range t[u] {
    if v == p {
      continue
    }
    cnt += solve(v, u, l ^ 1)
  }

  return cnt
}

func main() {
  scanf("%d\n", &n)

  for i := 0; i < n; i++ {
    var x int
    scanf("%d", &x)
    a = append(a, x)
  }
  scanf("\n")

  t = make([][]int, n + 1)
  for i := 1; i < n; i++ {
    var u, v int
    scanf("%d %d\n", &u, &v)
    t[u] = append(t[u], v)
    t[v] = append(t[v], u)
  }

  printf("%d\n", solve(1, 0, 1))
  writer.Flush()
}
