import sys
input = sys.stdin.readline


def check(max_budget):
    count = 0
    for budget in budget_list:
        if budget > max_budget:
            count = count + max_budget
        else:
            count = count + budget
    return count


n = int(input())
budget_list = list(map(int, input().split()))
limit_budget = int(input())

max_budget = max(budget_list)
min_budget, mid = 0, 0

while min_budget <= max_budget:
    mid = (min_budget + max_budget) // 2
    flag = limit_budget - check(mid)
    if flag >= 0:
        min_budget = mid + 1
    else:
        max_budget = mid - 1
print(max_budget)
