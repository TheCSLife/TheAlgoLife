# Project Teams
# https://www.acmicpc.net/problem/20044
n = int(input())
array = sorted(list(map(int, input().split())))
result = 100000000
for i in range(n):
    temp = array[i] + array[2 * n - 1 - i]
    result = min(result, temp)
print(result)
