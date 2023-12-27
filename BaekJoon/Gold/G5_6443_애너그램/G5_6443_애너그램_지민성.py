from collections import defaultdict
import sys
input = sys.stdin.readline

t = int(input())


def permutation(depth):
    global visited, k, stack
    if depth == k:
        print(''.join(stack))
    for key in visited:
        if visited[key] > 0:
            visited[key] = visited[key] - 1
            stack.append(key)
            permutation(depth + 1)
            stack.pop()
            visited[key] = visited[key] + 1


for _ in range(t):
    word = sorted(list(input().rstrip()))
    k = len(word)
    stack = []
    visited = defaultdict(int)
    for i in word:
        visited[i] = visited[i] + 1
    permutation(0)
