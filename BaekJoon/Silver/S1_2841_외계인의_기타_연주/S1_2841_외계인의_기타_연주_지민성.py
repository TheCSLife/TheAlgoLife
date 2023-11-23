# 외계인의 기타 연주
# https://www.acmicpc.net/problem/2841
from collections import defaultdict
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
music = defaultdict(list)
count = 0

for i in range(n):
    sound, fret = map(int, input().split())
    if not music[sound]:
        music[sound].append(fret)
        count = count + 1
    else:
        while music[sound]:
            if music[sound][-1] > fret:
                music[sound].pop()
                count = count + 1
            elif music[sound][-1] == fret:
                break
            else:
                music[sound].append(fret)
                count = count + 1
        if not music[sound]:
            music[sound].append(fret)
            count = count + 1
print(count)