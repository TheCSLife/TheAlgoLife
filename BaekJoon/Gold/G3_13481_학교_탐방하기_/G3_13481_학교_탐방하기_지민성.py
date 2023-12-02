import sys
input = sys.stdin.readline

n, m = map(int, input().split())
parent = [x for x in range(n + 1)]
load_list = [list(map(int, input().split())) for _ in range(m + 1)]
load_list.sort(key=lambda x: x[2])


def find(x):
    global parent
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]


def union(x, y):
    global parent
    x = find(x)
    y = find(y)
    parent[max(x, y)] = min(x, y)


max_value = 0
for a, b, cost in load_list:
    if find(a) != find(b):
        union(a, b)
        max_value = max_value + cost


min_value = 0
load_list.reverse()
parent = [x for x in range(n + 1)]
for a, b, cost in load_list:
    if find(a) != find(b):
        union(a, b)
        min_value = min_value + cost


print(abs((n - max_value) ** 2 - (n - min_value) ** 2))
