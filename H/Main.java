import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.Map;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author MaxHeap
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    HoudaAndAuction solver = new HoudaAndAuction();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) {
      solver.solve(i, in, out);
    }
    out.close();
  }

  static class HoudaAndAuction {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int days = in.nextInt();
      MultiSet<Integer> allBids = new MultiSet<>();
      long sum = 0;
      for (int i = 0; i < days; ++i) {
        int bidsForTheDay = in.nextInt();
        for (int j = 0; j < bidsForTheDay; ++j) {
          int bid = in.nextInt();
          allBids.add(bid);
        }
        Integer maxBid = allBids.lastKey();
        Integer minBid = allBids.firstKey();
        sum += (maxBid - minBid);
        allBids.remove(maxBid);
        allBids.remove(minBid);
      }
      out.println(sum);
    }
  }

  static class InputReader implements FastIO {

    private InputStream stream;
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int EOF = -1;
    private byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (this.numChars == EOF) {
        throw new UnknownError();
      } else {
        if (this.curChar >= this.numChars) {
          this.curChar = 0;

          try {
            this.numChars = this.stream.read(this.buf);
          } catch (IOException ex) {
            throw new InputMismatchException();
          }

          if (this.numChars <= 0) {
            return EOF;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) {
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) {
        res *= 10;
        res += c - 48;
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    public String next() {
      int c;
      while (isSpaceChar(c = this.read())) {
      }

      StringBuilder result = new StringBuilder();
      result.appendCodePoint(c);

      while (!isSpaceChar(c = this.read())) {
        result.appendCodePoint(c);
      }

      return result.toString();
    }

    public static boolean isSpaceChar(int c) {
      return c == 32 || c == 10 || c == 13 || c == 9 || c == EOF;
    }

  }

  static interface FastIO {

  }

  static class MultiSet<E> {

    private TreeMap<E, Integer> map;

    public MultiSet() {
      map = new TreeMap<>();
    }

    public MultiSet(Comparator<? super E> comparator) {
      map = new TreeMap<>(comparator);
    }

    public void add(E val) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }

    public void remove(E val) {
      Integer cur = map.get(val);
      if (cur == null) {
        return;
      }
      if (cur > 1) {
        map.put(val, cur - 1);
      } else {
        map.remove(val);
      }
    }

    public E firstKey() {
      return map.firstKey();
    }

    public E lastKey() {
      return map.lastKey();
    }

    public String toString() {
      return "MultiSet{" + "map=" + map + '}';
    }

  }
}
