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

type point struct {
  x, y, d int
}
func (p point) validate(n, m int) bool {
  return p.x >= 0 && p.y >= 0 && p.x < n && p.y < m
}

func solve(n, m, d int, g [][]byte) int {
  var ans int
  q := make([]point, 0, n * m)
  for i := 0; i < n; i++ {
    for j := 0; j < m; j++ {
      if g[i][j] == 'x' {
        q = append(q, point{ i, j, 0 })
        g[i][j] = 'v'
      } else if g[i][j] == 'o' {
        ans++
      }
    }
  }

  var dx = [4]int{1, -1, 0, 0}
  var dy = [4]int{0, 0, 1, -1}

  for len(q) > 0 {
    p := q[0]
    q = q[1:]

    if p.d == d {
      continue
    }

    for i := 0; i < 4; i++ {
      np := point{ p.x + dx[i], p.y + dy[i], 1 + p.d }
      if np.validate(n, m) && g[np.x][np.y] == 'o' {
        q = append(q, np)
        g[np.x][np.y] = 'v'
        ans--
      }
    }
  }

  return ans
}

func main() {
  var n, m, d int
  scanf("%d %d\n", &n, &m)

  var g [][]byte
  for i := 0; i < n; i++ {
    var line string
    scanf("%s\n", &line)
    g = append(g, []byte(line))
  }
  scanf("%d\n", &d)

  printf("%d\n", solve(n, m, d, g))
  writer.Flush()
}
