from collections import deque


def solution(people, limit):
    answer = 0
    people.sort()
    people = deque(people)
    while people:
        if len(people) >= 2:
            if people[0] + people[-1] <= limit:
                people.pop()
                people.popleft()
                answer = answer + 1
            else:
                people.pop()
                answer = answer + 1
        else:
            answer = answer + 1
            break
    return answer