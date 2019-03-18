package main

// author: Mouad Naciri

import (
	"bufio"
	"fmt"
	"os"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)

func printf(f string, a ...interface{}) { fmt.Fprintf(writer, f, a...) }
func scanf(f string, a ...interface{})  { fmt.Fscanf(reader, f, a...) }

var ans = []int{ 1, 1, 2, 6, 4 }
func solve(n int) int {
  if n < 5 {
    return ans[n]
  }

  return 0
}

func main() {
  var t int
  scanf("%d\n", &t)

  for i := 0; i < t; i++ {
    var n int
    scanf("%d\n", &n)
    printf("%d\n", solve(n))
  }

  writer.Flush()
}
