rekke =[]
indx = 0

for i in range(1, 1338):
    if i%7 != 0 and '7' not in str(i):
        rekke.append(i)
    else:
        rekke.append(rekke[indx])
        indx+= 1
print rekke
