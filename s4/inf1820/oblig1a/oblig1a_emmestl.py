# *-* encoding: utf-8 *-*

#1. Variabler
'''
1. GYLDIG:  Noe lang og lite informativ men inneholder kun lovlige symboler og tegn
2. UGYLDIG: I python kan ikke variabelnavn starte med tall, vil gi en SyntaxError
3. GYLDIG:  Inneholder kun lovlige boksatver
4. UGYLDIG: "-" bli av python tolket som et minus tegn.
5. UGYLDIG: "if" er som i java en innebygd funksjon og kan ikke brukes som variabelnavn
6. GYLDIG:  Samme begrunnelse som de andre Gyldige
7. UGYLDIG: Variabelnavn kan ikke inneholde mellomrom
8. GYLDIG:  En variabel kan godt inneholde tall så lenge de ikke er først i ordet
9. GYLDIG:  Samme begrunnelse som nr. 1
10.GYLDIG:  Alle bokstavene kan fint være i capslock. Men etter konvensjon er dette bare globale konstente variabler
'''

#2. Strenger
#2.1
def er_contains(text):
    print'nr of occurunces of "er" is: ',  text.count('er')

#2.2
def er_count(text):
    print'nr of words ending with "er " are:  ',  text.count('er '), '\n'

#2.3
def last_two(text):
    word_list = text.split() #default slipt at ' '

    for i in range (len(word_list)):
        word_list[i] = word_list[i][-2:]

    print 'last to symbols per word:\n', word_list, '\n'
    return word_list

#2.4
def back_to_string(word_list):
    print 'back to a string:\n', " ".join(word_list), '\n'



#extra function to read in the text from file
def read_text(text):
    book = ""
    file = open(text, 'r')
    for lines in file:
        book += lines

    file.close()    
    return book



#3. Løkker og heltall
#3.1
def add42(l):
    for i in range(len(l)):
        l[i] = l[i]+42

    return l


#3.2
def altsum(n):
    sum = 0
    for i in range(len(n)):
        if i % 2 == 0:
            sum += n[i]
        else:
            sum -= n[i]

    return sum
        

def main():
    #2
    text =  read_text('MarkensGrode.txt')
    er_contains(text)
    er_count(text)
    back_to_string(last_two(text))

    #3
    '''
    for å kalle funksjonen skjervet i oppgave 3 åpne en terminal og gjør følgende:
    $ python
    >>> from oblig1a_emmestl import add42, altsum
    >>> oblig1a_emmestl.add42([1, 1, 3])
    >>> oblig1a_emmestl.altsum([1, 1, 3])
    '''
    
if __name__ == "__main__":
    main()
