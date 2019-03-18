package main
//
// author: Mouad Nacirir
//
import (
	"bufio"
	"fmt"
	"os"
  "sort"
)

var reader *bufio.Reader = bufio.NewReader(os.Stdin)
var writer *bufio.Writer = bufio.NewWriter(os.Stdout)

func printf(f string, a ...interface{}) { fmt.Fprintf(writer, f, a...) }
func scanf(f string, a ...interface{})  { fmt.Fscanf(reader, f, a...) }

var y = "Awesome anagram\n"
var n = "Azuz is not my leader\n"

func solve(s, t []byte) bool {
  if len(t) <= 2 || len(s) <= 2 {
    return string(s) == string(t)
  }

  if len(t) != len(s) || s[0] != t[0] || s[len(s) - 1] != t[len(t) - 1] {
    return false
  }
  sinside := s[1:len(s) - 1]
  tinside := t[1:len(t) - 1]

  sort.Slice(sinside, func(i, j int) bool { return sinside[i] < sinside[j] })
  sort.Slice(tinside, func(i, j int) bool { return tinside[i] < tinside[j] })

  return string(s) == string(t)
}

func main() {
  var t int
  scanf("%d\n", &t)

  for i := 0; i < t; i++ {
    var s, r string
    scanf("%s %s\n", &s, &r)

    if solve([]byte(s), []byte(r)) {
      printf(y)
    } else {
      printf(n)
    }
  }

  writer.Flush()
}
