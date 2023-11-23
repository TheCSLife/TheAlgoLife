# 알파벳
# https://www.acmicpc.net/problem/1987
import sys
input = sys.stdin.readline


def dfs(x, y, count):
    global result
    result = max(result, count)
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            continue
        if ground[nx][ny] in visited:
            continue
        else:
            visited.add(ground[nx][ny])
            dfs(nx, ny, count + 1)
            visited.remove(ground[nx][ny])


r, c = map(int, input().split())
ground = [list(input().strip()) for _ in range(r)]
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

result = 0
visited = set()
visited.add(ground[0][0])
dfs(0, 0, 1)
print(result)
