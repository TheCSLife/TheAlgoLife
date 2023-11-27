import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    keys = list(input().rstrip())
    left, right = [], []
    for key in keys:
        if key == "-":
            if left:
                left.pop()
        elif key == "<":
            if left:
                right.append(left.pop())
        elif key == ">":
            if right:
                left.append(right.pop())
        else:
            left.append(key)
    right.reverse()
    print("".join(left + right))
