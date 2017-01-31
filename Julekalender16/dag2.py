pos = 0
prev = 1
pprev = 1

while prev < 4000000000:
    if prev%2 == 0:
        pos += prev


    prev, pprev = prev+pprev, prev

print pos
