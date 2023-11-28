import sys
input = sys.stdin.readline

n = int(input())
words = [list(input().rstrip()) for _ in range(n)]
numbers = [0] * 26

# 자리수 계산
for word in words:
    for index, value in enumerate(word):
        k = ord(value) - ord("A")
        numbers[k] = numbers[k] + 10 ** (len(word) - index - 1)
numbers.sort(reverse=True)

# 큰수대로 9부터 곱해줌
result, order = 0, 9
for number in numbers:
    if number == 0:
        break
    result = result + number * order
    order = order - 1
print(result)
