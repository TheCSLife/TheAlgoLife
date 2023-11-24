from collections import defaultdict
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    dic = defaultdict(int)
    array = list(map(int, input().split()))
    n = array[0]
    soldier_list = array[1:]
    for soldier in soldier_list:
        dic[soldier] = dic[soldier] + 1
    for value in dic:
        if n % 2 == 0:
            if dic[value] > n // 2:
                print(value)
                break
        else:
            if dic[value] > n // 2:
                print(value)
                break
    else:
        print("SYJKGW")
