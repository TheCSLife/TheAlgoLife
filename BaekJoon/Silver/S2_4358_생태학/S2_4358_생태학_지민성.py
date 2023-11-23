# 생태학
# https://www.acmicpc.net/problem/4358
from collections import defaultdict
import sys
input = sys.stdin.readline

dic = defaultdict(int)
array = []
total_count = 0
while True:
    word = input().rstrip()
    if not word:
        break
    dic[word] = dic[word] + 1
    total_count = total_count + 1

for i in dic:
    if i == "":
        continue
    array.append([i, dic[i]])

array.sort()
for value in array:
    print('%s %.4f' %(value[0], value[1] / total_count * 100))
