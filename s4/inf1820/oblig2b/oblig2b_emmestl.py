# encoding: utf-8

import nltk
from nltk.probability import FreqDist


print 'Oppgave 2:'
print 

def zipfity(lst):
    unigram = FreqDist()

    for sent in lst:
        for word in sent:
            unigram[word.lower()] +=1 #the task didn't say anything so did it all to lower

    sorted_unigram = sorted(unigram, key = unigram.get, reverse = True)
    top10 = sorted_unigram[:10]
    most_freq = unigram.freq(top10[0])
    count = 1

    print '{0:7s}{1:10s}{2:10s}'.format('word', 'obs.freq(%) ', 'zipf-law(%)')
    print '----------------------------'
    for word in top10:
        print '{0:7s}{1:10.2f}{2:10.2f}'.format(word, unigram.freq(word)*100, (most_freq/count)*100)
        count += 1


news = nltk.corpus.brown.sents(categories= "news")
zipfity(news)

#ser at den teoretiske sansynligheten avtar fortere enn den faktiske. Men dette har en god del å gjøre med at vi tester på et endelig stort sett. Så kan fort nærme seg dette hvis vi hadde testet på større data.  







print '----------------------------'
print
print 'Oppgave 3:'
print 

def reg_tag():
    pattern = [  (r'.*ing$', 'VBG'),
                 (r'.*ed$', 'VBD'),
                 (r'.*es$', 'VBZ'),
                 (r'.*ould$', 'MD'),
                 (r'.*\'s$', 'NN$'),
                 (r'.*s$', 'NNS'),
                 (r'^-?[0-9]+(.[0-9]+)?$', 'CD'),
                 (r'.*able$', 'JJ'),
                 (r'^([Tt]he|[Aa]|[Aa]n|[Nn]o|[Ee]very)$', 'AT'),
                 (r'^[\.\:\;\?]$', '.'),
                 (r'.*', 'NN')
    ]
    regexp_tagger = nltk.RegexpTagger(pattern)

    for sents in nltk.corpus.brown.sents(categories = "adventure"):
        regexp_tagger.tag(sents)

    for sents in nltk.corpus.brown.sents(categories = "fiction"):
        regexp_tagger.tag(sents)

        
    print 'Adventure: ', regexp_tagger.evaluate(nltk.corpus.brown.tagged_sents(categories = "adventure"))
    print 'Fiction:   ', regexp_tagger.evaluate(nltk.corpus.brown.tagged_sents(categories = "fiction"))
    
reg_tag()

"""
Jeg rakk ikke mer enn å finne to selv og den tredje som ble gitt i eksempel i oppgaven. Men ser alikevel en forbedring på ca 0.2 på test corpuset. 

De jeg har funnet er enkelte spesial ord, kan finens i listen under og hvilken ttag de skal ha. Eksempel på .-klassen er enkelt og greit ., og i AT-klassen er the et. 
https://www.comp.leeds.ac.uk/ccalas/tagsets/brown.html 


Kjørte så pattern på fiction. Siden jeg bare la til 3 tags så er det ikke en reel forskjell å se her. Så de tags-ene jeg har funnet til nå virker å være ganske universell uansett tekst. Noe som kankje ikke er så rart ettersom det er enkeltord og tegn jeg har tagget. 
"""
