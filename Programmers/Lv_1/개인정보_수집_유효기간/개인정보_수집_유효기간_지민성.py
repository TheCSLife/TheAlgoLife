from collections import defaultdict


def convert(today):
    y, m, d = map(int, today.split("."))
    return (y * 12 + m) * 28 + d


def solution(today, terms, privacies):
    answer = []

    dic = defaultdict(int)
    for info in terms:
        alphabet, term = info.split()
        dic[alphabet] = int(term)

    today = convert(today)
    for index, privacy in enumerate(privacies):
        data, term = privacy.split()
        value = convert(data) + dic[term] * 28
        if value <= today:
            answer.append(index + 1)
    return answer


print(solution("2022.05.19", ["A 6", "B 12", "C 3"], ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]))
print(solution("2020.01.01",["Z 3", "D 5"], ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]))