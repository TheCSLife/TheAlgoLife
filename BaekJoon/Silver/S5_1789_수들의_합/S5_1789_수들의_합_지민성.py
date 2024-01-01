# 수들의 합
# https://www.acmicpc.net/problem/1789
n = int(input())
x = 0
while True:
    k = x * (x + 1)
    if 2 * n < k:
        x = x - 1
        break
    if 2 * n < k:
        break
    x = x + 1
print(x)
