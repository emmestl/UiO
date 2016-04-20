# encoding: utf-8

import nltk
from math import log, pow
from nltk import bigrams
from nltk.probability import ConditionalFreqDist, FreqDist, ConditionalProbDist, LaplaceProbDist

class LM:
    def __init__(self):
        self.bigrams = ConditionalFreqDist()
        self.unigrams = FreqDist()
        sentences = nltk.corpus.brown.sents(categories=nltk.corpus.brown.categories()[1:])

        for sent in sentences:
            # Vi utvider setningen med None foran, for å angi start av
            # setningen, og en None etter, for å markere setningsslutt.
            sent = [None] + sent + [None]
            for prev, word in bigrams(sent):
                self.bigrams[prev][word] += 1
                self.unigrams[word] += 1

        self.bigrams = ConditionalProbDist(self.bigrams, LaplaceProbDist)
        self.unigrams = LaplaceProbDist(self.unigrams)
        

    def p(self, w, prev):
        p = 0.5*self.unigrams.prob(w)
        if prev in self.bigrams:
            p += self.bigrams[prev].prob(w)
        return p

    def logprob(self, s):
        prob = 0

        if(isinstance(s, basestring)):
            s = s.split()
                
        for prev, w in bigrams(s):
            prob += log(self.p(w, prev), 2)

        return prob


    def perplexity(self, sents):
        l = 0
        N = 0
        for s in sents:
            l += self.logprob(s)
            N += len(s)

        return pow(2, -l/N)


#Testing
m = LM()
print 'news ', m.perplexity(nltk.corpus.brown.sents(categories="news"))
print 'adventure ', m.perplexity(nltk.corpus.brown.sents(categories="adventure"))

print """
Vi ser at adventure scorer nesten 30% bedre enn news. Dette har med at adveture er en av tekstene vi har trent modellen vår på. Det vil si den har sett teksten før, dette er ikke tilfellet med news. Altså vil denne gi en mye lavere score ettersom det kan forekomme sekvenser av ord/enkelt ord som ikke hvar vært sett før.

Det vi får ut av dette er at det er viktig å skille mellom treningsdata og data som skal testes. For ellers kan vi få unaturlig høyt utslag på sannsynligheten av en tekst. Og vil gi feil indikasjoner på hvor bra modelen faktisk er til å gjennkjenne lovlige setninger utifra ukjent data. """
