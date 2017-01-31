message = 'Your message was received with gratitude! We do not know about you, but Christmas is definitely our favourite holiday. The tree, the lights, all the presents to unwrap. Could there be anything more magical than that?! We wish you a happy holiday and a happy new year!'

message = message.lower()

romer = ['0', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX', 'X', 'XI', 'XII', 'XIII']

code = ''

for i in range(len(message), 0, -1):
    s = message[i-1]
    if (ord(s)- 97) < 0 or (ord(s)- 97) > 25:
        if s== '0':
            code = '0, ' + code + ', 0'
    else:
        temp = ((ord(s)-97)+1)/2
        if ((ord(s)-97)+1)%2 == 1:
            code = romer[temp+1] + ', ' + code + ', ' + romer[temp]
        else:
            code = romer[temp] + ', ' + code + ', ' + romer[temp]



print code
