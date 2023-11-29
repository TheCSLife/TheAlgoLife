def solution(triangle):
    for row in range(len(triangle)):
        if row == 0:
            continue
        for i in range(row + 1):
            if i == 0:
                triangle[row][i] = triangle[row][i] + triangle[row - 1][i]
            elif i == row:
                triangle[row][i] = triangle[row][i] + triangle[row - 1][i - 1]
            else:
                triangle[row][i] = triangle[row][i] + max(triangle[row - 1][i - 1], triangle[row - 1][i])
    return max(triangle[-1])


print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))