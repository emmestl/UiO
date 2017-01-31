import nltk, re, pprint
from nltk.probability import ConditionalFreqDist
from nltk.corpus import conll2000


par = ConditionalFreqDist()
tags = ConditionalFreqDist()
sentences = nltk.corpus.brown.tagged_sents(categories=nltk.corpus.brown.categories())
tot = 0
                                           

for sent in sentences:
    new_sent = []
    for word, tag in sent:
        tot += 1
        par[tag][word.lower()] += 1
        new_sent.append(tag)

    new_sent = [None] + new_sent + [None]
    for prev, word in nltk.bigrams(new_sent):
        tags[prev][word]  += 1

print 'oppgave 1.1'
tot = 0
for word in par['NN']:
    tot += par['NN'][word]
print 'light som substantiv: ', par['NN']['light']*1.0 / tot
tot = 0
for word in par['VB']:
    tot += par['VB'][word]
print 'light som verb: ', par['VB']['light']*1.0 / tot
    
print '\noppgave 1.2'
max_val = 0
max_vb = None
ant_jj = 0
for ord in par['VB']:
    if par['VB'][ord] > max_val:
        max_val = par['VB'][ord]
        max_vb = ord
for ord in par['JJ']:
    if par['JJ'][ord] == 1:
        ant_jj += 1
        
print 'det mest frekvente verbet er', max_vb, 'og forekommer', max_val, 'antall ganger'
print '\noppgave 1.3'
print 'antall adjektiv som kun forekommer en gang er: ', ant_jj


print '\noppgave 1.4'
cpd = nltk.ConditionalProbDist(tags, nltk.MLEProbDist)

print 'sannsynligheten for: DT, NN', cpd['DT'].prob('NN')
print 'sannsynligheten for: DT, JJ', cpd['DT'].prob('JJ')
print 'sannsynligheten for: JJ, JJ', cpd['JJ'].prob('JJ')
print 'sannsynligheten for: JJ, NN', cpd['JJ'].prob('NN')
    
print '\noppgave 1.5'
print 'den mest sansynlige taggen etter et adverb er: ', cpd['RB'].max()
    

print '\n\noppgave 2'
tot = 0
for word in par['PP$']:
    tot += par['PP$'][word]
print 'hvis duck == and: ', cpd['VBD'].prob('PP$') * cpd['PP$'].prob('NN') * (par['NN']['duck']*1.0/tot)
tot = 0
for word in par['PPO']:
    tot += par['PPO'][word]
print 'hvis duck == dukke: ', cpd['VBD'].prob('PPO') * cpd['PPO'].prob('VB') * (par['VB']['duck']*1.0/tot)

print '\nDen mest sansynlige setningen er hvor duck er en and'



print '\n\noppgave 3'
grammar = r'''
NP: {<RB>?<DT>?<JJ>*<NN>+}
{<NNP>+}
{<NN>+}
{<NP>+}
{<RB>?<DT><JJ>*<CD>?<NNS>}
{<DT><JJ><JJ><NNP><NNS>}
{<DT><NNP><NNP><NNP><NNP><JJ><NN>}
{<DT><JJ><NNP><CC><JJ><JJ><NN><NNS>}
{<RB><DT><JJS><NN><NN><SBAR>}
{<DT><VBG><JJ><NNP><NNP><CC><NNP>}
'''

#samtliger regler er her hentet fra side 441 i Jurafsky and Martin

cp = nltk.RegexpParser(grammar)

training = conll2000.chunked_sents("train.txt", chunk_types=["NP"])
print 'training data: ', nltk.chunk.util.accuracy(cp, training)


test = conll2000.chunked_sents("test.txt", chunk_types=["NP"])
print 'test data: ', nltk.chunk.util.accuracy(cp, test)

print 'det er ikke en spesiell stor forskjell her fordi reglenene er ikke tilpasset et spesiellt type sett'
