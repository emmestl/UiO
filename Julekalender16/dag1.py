tall = 6
new = 0
loop = 0
while tall < 1000000:
    loop += 1
    new = tall * 4

    if new/10**(len(str(new))-1) == 6 and tall//10 == new%(10**(len(str(new))-1)):
        print tall
        break


    tall = (new%10**(len(str(new))-1))*10 + 6

