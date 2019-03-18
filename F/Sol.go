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

func main() {
  var n int
  scanf("%d\n", &n)

  var a []int64
  var z int
  for i := 0; i < n; i++ {
    var x int64
    scanf("%d", &x)
    if x == 0 {
      z++
    } else {
      a = append(a, x)
    }
  }

  a = append(a, make([]int64, z)...)
  for i, x := range a {
    if i > 0 {
      printf("  ")
    }
    printf("%d", x)
  }

  writer.Flush()
}
