from collections import deque
import sys
input = sys.stdin.readline

n, k, m = map(int, input().split())
queue = deque()
for i in range(n):
    queue.append(i + 1)

turn = 0
while queue:
    if (turn // m) % 2 == 1:
        for _ in range(k):
            temp = queue.pop()
            queue.appendleft(temp)
    else:
        for _ in range(k - 1):
            temp = queue.popleft()
            queue.append(temp)
    print(queue.popleft())
    turn = turn + 1
