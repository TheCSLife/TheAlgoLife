import sys
input = sys.stdin.readline

n = int(input())
budget_list = list(map(int, input().split()))
limit_budget = int(input())
max_budget = max(budget_list)

while True:
    count = 0
    for budget in budget_list:
        if budget > max_budget:
            count = count + max_budget
        else:
            count = count + budget
    if count <= limit_budget:
        break
    max_budget = max_budget - 1
print(max_budget)
