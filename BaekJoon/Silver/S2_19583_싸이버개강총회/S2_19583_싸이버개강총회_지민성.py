import sys
input = sys.stdin.readline


def convert(time):
    hour, minute = time.split(":")
    return hour * 60 + minute


start, end, check = input().split()
start, end, check = convert(start), convert(end), convert(check)
before, after = set(), set()

while True:
    try:
        time, name = input().split()
        time = convert(time)
        if time <= start:
            before.add(name)
        if end <= time <= check:
            after.add(name)
    except ValueError:
        break

print(len(before & after))
