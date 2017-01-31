def desimal(i):
    roman = ['0', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX', 'X', 'XI', 'XII', 'XIII']

    for j in range(len(roman)):
        if roman[j] == i:
            return j

    print 'somethings wrong'


    
f = open('inputdag5.txt', 'r')
codes = f.readline()[1:-2].split(', ')
f.close()

message = []
i = 0

while(i < len(codes)/2):
    message.append(desimal(codes[i]))
    message[i] += desimal(codes[-i-1])

    message[i] = chr(message[i] + 96)
    
    i += 1

print ''.join(message)

