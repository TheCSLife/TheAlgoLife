# 무기 공학
# https://www.acmicpc.net/problem/18430
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
# 우, 하, 좌, 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
result = 0

def backtracking(xx, yy, value):
    global result
    if xx == n - 1 and yy == m - 1:
        return
    for x in range(xx - 1, n):
        for y in range(yy - 1, m):
            if visited[x][y]:
                continue
            for d in range(4):
                flag = True
                for i in range(2):
                    nx = x + dx[(d + i) % 4]
                    ny = y + dy[(d + i) % 4]
                    if nx < 0 or nx >= n or ny < 0 or ny >= m:
                        flag = False
                        break
                    if visited[nx][ny]:
                        flag = False
                        break
                if flag:
                    visited[x][y] = True
                    current = board[x][y] * 2
                    for i in range(2):
                        nx = x + dx[(d + i) % 4]
                        ny = y + dy[(d + i) % 4]
                        visited[nx][ny] = True
                        current = current + board[nx][ny]
                    result = max(result, value + current)
                    backtracking(x, y, value + current)
                    visited[x][y] = False
                    for i in range(2):
                        nx = x + dx[(d + i) % 4]
                        ny = y + dy[(d + i) % 4]
                        visited[nx][ny] = False


backtracking(0, 0, 0)
print(result)