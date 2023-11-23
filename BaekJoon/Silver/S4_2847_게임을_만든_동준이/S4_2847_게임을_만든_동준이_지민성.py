# 게임을 만든 동준이
# https://www.acmicpc.net/problem/2847
import sys
input = sys.stdin.readline

n = int(input())
score_list = [int(input()) for _ in range(n)]
score_list.reverse()

result, current = 0, score_list[0]
for i in range(1, n):
    if current <= score_list[i]:
        delta = abs(score_list[i] - current) + 1
        result = result + delta
        current = score_list[i] - delta
    else:
        current = score_list[i]
print(result)