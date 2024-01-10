# 카드 합체 놀이
# https://www.acmicpc.net/problem/15903
import heapq
import sys
input = sys.stdin.readline

a, b = map(int, input().split())
heap = list(map(int, input().split()))
heapq.heapify(heap)

for _ in range(b):
    x = heapq.heappop(heap)
    y = heapq.heappop(heap)
    k = x + y
    heapq.heappush(heap, k)
    heapq.heappush(heap, k)

print(sum(heap))
