# 주식
# https://www.acmicpc.net/problem/11501
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    cost_list = list(map(int, input().split()))
    total_cost, max_cost = 0, 0
    while cost_list:
        cost = cost_list.pop()
        if max_cost > cost:
            total_cost = total_cost + max_cost - cost
            continue
        max_cost = cost
    print(total_cost)
