from collections import deque, defaultdict


def solution(land):
    row, col = len(land), len(land[0])
    dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
    visited = [[False] * col for _ in range(row)]
    dic = defaultdict(int)
    order = 0
    for i in range(row):
        for j in range(col):
            if land[i][j] == 1 and not visited[i][j]:
                order = order + 1
                stack = []
                count = 1
                queue = deque()
                queue.append([i, j])
                stack.append([i, j])
                visited[i][j] = True
                while queue:
                    x, y = queue.popleft()
                    for d in range(4):
                        nx = x + dx[d]
                        ny = y + dy[d]
                        if nx < 0 or nx >= row or ny < 0 or ny >= col:
                            continue
                        if visited[nx][ny] or land[nx][ny] == 0:
                            continue
                        queue.append([nx, ny])
                        stack.append([nx, ny])
                        count = count + 1
                        visited[nx][ny] = True
                for x, y in stack:
                    land[x][y] = order
                dic[order] = count
    result = 0
    for i in range(col):
        temp_set = set()
        for j in range(row):
            temp_set.add(land[j][i])
        temp = 0
        for idx in temp_set:
            temp = temp + dic[idx]
        result = max(result, temp)
    return result

print(solution([[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]))
print(solution([[1, 0, 1, 0, 1, 1], [1, 0, 1, 0, 0, 0], [1, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0], [1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1]]))
