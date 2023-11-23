# 근손실
# https://www.acmicpc.net/problem/18429
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
weight_list = list(map(int, input().split()))
result = 0
visited = [False] * n


def permutaion(depth, visited, weight):
    global result
    if weight < 500:
        return
    if depth == n:
        result = result + 1
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            permutaion(depth + 1, visited, weight + weight_list[i] - k)
            visited[i] = False


permutaion(0, visited, 500)
print(result)
