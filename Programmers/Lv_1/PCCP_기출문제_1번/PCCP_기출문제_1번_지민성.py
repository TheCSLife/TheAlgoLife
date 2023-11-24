def solution(bandage, health, attacks):
    t = 1
    hp = health
    index = 0
    continuous = 0
    while index < len(attacks):
        for time, damage in attacks[index:]:
            if t == time:
                hp = hp - damage
                continuous = 0
                index = index + 1
                if hp <= 0:
                    return -1
                break
        else:
            hp = hp + bandage[1]
            continuous = continuous + 1
            if continuous == bandage[0]:
                hp = hp + bandage[2]
                continuous = 0
            if hp > health:
                hp = health
        t = t + 1
    return hp