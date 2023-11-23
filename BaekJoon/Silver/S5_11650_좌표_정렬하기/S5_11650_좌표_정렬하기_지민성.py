n = int(input())
coordinate_list = [list(map(int, input().split())) for _ in range(n)]
coordinate_list.sort(key=lambda x: (x[0], x[1]))
for coordinate in coordinate_list:
    print(*coordinate)
