spillere = [1 for i in range(1337)]
stiger = {3:17, 8:10, 15:44, 22:5, 39:56, 49:75, 62:45, 64:19, 65:73, 80:12, 87:79}

f = open('dag8', 'r')
spiller = 0
ant_stige = 0
for linje in f:
    spillere[spiller%1337] += int(linje)

    if spillere[spiller%1337] > 90:
        spillere[spiller%1337] -= int(linje)
    if spillere[spiller%1337] == 90:
        print ant_stige*(spiller%1337 +1)
        break
    
    if spillere[spiller%1337] in stiger:
        ant_stige+= 1
        spillere[spiller%1337] = stiger[spillere[spiller%1337]]

    spiller += 1
