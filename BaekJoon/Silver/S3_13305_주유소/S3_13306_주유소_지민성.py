n = int(input())
oil = list(map(int, input().split()))
cost = list(map(int, input().split()))
current, target, result = 0, 0, 0

while True:
    current_cost = cost[current]
    for i in range(current, n):
        if current_cost > cost[i]:
            target = i
            break
        if i == n - 1:
            target = n - 1
            break
    for i in range(current, target):
        result = result + oil[i] * current_cost
    current = target
    if current == n - 1:
        break

print(result)
