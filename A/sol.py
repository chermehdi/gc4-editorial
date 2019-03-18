# author: Azuz Eraoui

def solve(n):
    res = n
    i = 2

    while i * i <= n:
        if n % i == 0:
            while n % i == 0:
                n = n // i
            res = res - res // i

        i = i + 1
    if n > 1 :
        res -= res // n
    return res

t = int(input())
for ttt in range(t):
    print(solve(int(input())))
