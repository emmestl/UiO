thief = 1
wizard = 1
warrior = 1
priest = 1
power = 0

def reset():
    global wizard
    global warrior
    global priest
    global power
    if wizard == -1:
        wizard = 0
    if warrior == -1:
        warrior = 0
    if priest == -1:
        priest = 0
    power = 0

def survivors():
    global wizard
    global warrior
    global priest

    sur = 0
    if thief == 1:
        sur += 1
    if warrior == 1:
        sur += 1
    if wizard == 1:
        sur += 1
    if priest == 1:
        sur += 1
    return sur


def rules(goblins):
    global wizard
    global warrior
    global priest
    global power
    
    if thief == 1:
        goblins -= 1

    if wizard == 1:
        goblins -= 10

    if warrior == 1:
        goblins -= 1


    if priest == 1 and power == 0:
        if warrior == -1:
            warrior = 1
            power = 1
        elif wizard == -1:
            wizard = 1
            power = 1

    if goblins <= 0:
        return 0

    if thief == 1 and wizard != 1 and warrior !=1 and priest != 1:
        return goblins

    sur = survivors()
    if sur*10 <= goblins:
        if warrior == 1:
            warrior = -1
        elif wizard == 1:
            wizard = -1
        elif priest ==1:
            priest = -1

    if goblins == 0:
        return 0
    return rules(goblins)


goblins = 0
for i in range(1, 101):
    goblins += rules(i)
    reset()
    
print ('priest', priest, '\nwarrior', warrior, '\nwizard', wizard, '\nthief', thief)
print goblins
