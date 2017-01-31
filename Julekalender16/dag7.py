f = open('dag7', 'r')
n = 0
v = 0

for line in f:
    tmp = line.split()
    print tmp
    #print line
    if 'north' in tmp[3]:
        n += int(tmp[1])
    if 'south' in tmp[3]:
        n -= int(tmp[1])
    if 'west' in tmp[3]:
        v += int(tmp[1]) 
    if 'east' in tmp[3]:
        v -= int(tmp[1])
        
f.close()

print n, v
