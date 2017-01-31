adress = {'None': 0}

f = open('dag9', 'r')

for line in f:
    inp = line.split(',')
    print inp
    if inp[0] not in adress:
        adress[inp[0]] = 0
    if inp[1] not in adress:
        adress[inp[1]] = 0

    adress[inp[0]] -= int(inp[2])
    adress[inp[1]] += int(inp[2])

f.close()

ant = 0
for key in adress:
    if adress[key] > 10:
        ant += 1
    
    
print ant
