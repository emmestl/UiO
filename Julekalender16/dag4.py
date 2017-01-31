nr = [i for i in range(1, 1338)]
change = []

def nr_change(debth):
    if len(change) == debth:
        change.append([1])
        return 1


    new = len(change[debth]) +1 
    if new%7 == 0 or '7' in str(new):
        change[debth].append(nr_change(debth+1))
        return change[debth][-1]

    else:
        change[debth].append(new)
        return new


for i in range(1337):
    if (i+1)%7 == 0 or '7' in str(i+1):
        nr[i] = nr_change(0)



for i in range(len(change[0])):
    print i , '   ', change[0][i]
