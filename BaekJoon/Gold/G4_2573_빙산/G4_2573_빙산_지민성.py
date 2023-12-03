from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
iceberg = [list(map(int, input().split())) for _ in range(n)]
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
count = 0


def melt():
    global count
    count = count + 1
    melt_list = [[0] * m for _ in range(n)]
    all_zero_flag = True
    for x in range(n):
        for y in range(m):
            if iceberg[x][y] == 0:
                continue
            all_zero_flag = False
            for d in range(4):
                nx = x + dx[d]
                ny = y + dy[d]
                if nx < 0 or nx >= n or ny < 0 or ny >= m:
                    continue
                if iceberg[nx][ny] == 0:
                    melt_list[x][y] = melt_list[x][y] + 1
    if all_zero_flag:
        print(0)
        exit(0)
    for x in range(n):
        for y in range(m):
            iceberg[x][y] = max(0, iceberg[x][y] - melt_list[x][y])


def is_separated():
    visited = [[False] * m for _ in range(n)]
    check = 0
    for i in range(n):
        for j in range(m):
            if iceberg[i][j] == 0 or visited[i][j]:
                continue
            check = check + 1
            queue = deque()
            queue.append([i, j])
            visited[i][j] = True
            while queue:
                x, y = queue.popleft()
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if nx < 0 or nx >= n or ny < 0 or ny >= m:
                        continue
                    if iceberg[nx][ny] != 0 and not visited[nx][ny]:
                        queue.append([nx, ny])
                        visited[nx][ny] = True
    if check > 1:
        return True
    return False


while True:
    if is_separated():
        break
    melt()

print(count)
