# *-* encoding: utf-8 *-*
import re

'''
2.1)
Antar at æ,ø,å ikke er en del av de alfanumeriske tegnene (hverken upper- eller lowercase).
Wikipedia sier videre at et domenenavn hverken kan starte eller slutte med "-", at store og små bokstaver tolkes likt og at navnet må være et sted mellom [1, 63] tegn langt. Det står også at et domenenavn starter med "." (tegnet lengst til høyre) men siden dette ikke er vanlig velger jeg å la begge deler være en mulighet

kilde: https://no.wikipedia.org/wiki/Domenenavn

/([a-zA-Z0-9]\.?([a-zA-Z0-9\-]\.?){0,61})?[a-zA-Z0-9]\.?/
 


2.2
Finner ikke at det skal være noen max begrensing på stilengde så lager den så lang den måtte ønske

/(\/[^\/])*\/?/



2.3

En http eller en https adresse starter enten med  http:// eller https:// etterfulgt av et domenenavn (2.1) og så en path (2.2)
Får altså:

/https?:\/\/([a-zA-Z0-9]\.?([a-zA-Z0-9\-]\.?){0,61})?[a-zA-Z0-9]\.?(\/[^\/]+)*\/?/

kun "https?:\/\/" som er nytt.

'''


#3

def main():
    syllables = {}
    file = open("right-ho-Jeeves.txt", 'r')
    for line in file:
        words = line.split()
        for word in words:
            if (is_syllable(word)):
                if (syllables.get(word) == None):
                    syllables[word] = 0
                else:
                    syllables[word] += 1

    file.close()
    
    print len(syllables), 'unike syllables are in the book'
    #print syllables.keys()


def is_syllable(word):
    return re.search('^[bcdfghjklmnpqrstvwxz]*[aeiouy]+[bcdfghjklmnpqrstvwxz]*$', word)


if __name__ == "__main__":
    main()


'''
3.1 En kjøring gir at boken inneholder 1245 unike enstavelses ord

3.2 playing, laying, saying

3.3 take, have, are
'''
