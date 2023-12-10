t = int(input())
coins = [1, 2, 3]
numbers = [int(input()) for _ in range(t)]
max_number = max(numbers)
dp = [0] * (max_number + 1)
dp[0] = 1

for coin in coins:
    for i in range(coin, max_number + 1):
        if i - coin >= 0:
            dp[i] = dp[i] + dp[i - coin]

for number in numbers:
    print(dp[number])
