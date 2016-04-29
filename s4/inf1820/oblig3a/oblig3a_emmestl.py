import nltk
from nltk.probability import ConditionalFreqDist


def oppgave1():
    par = ConditionalFreqDist()
    tags = ConditionalFreqDist()
    sentences = nltk.corpus.brown.tagged_sents(categories=nltk.corpus.brown.categories())
    
                                           

    for sent in sentences:
        new_sent = []
        for word, tag in sent:
            par[word.lower()][tag] += 1
            new_sent.append(tag)

        new_sent = [None] + new_sent + [None]
        for prev, word in nltk.bigrams(new_sent):
            tags[prev][word]  += 1


    print 'oppgave 1.1'
    print 'light som substantiv: ', par['light']['NN']
    print 'light som verb: ', par['light']['VB']
    
    print '\noppgave 1.2'
    max_val = 0
    max_vb = None
    ant_jj = 0
    for ord in par:
        if par[ord]['VB'] > max_val:
            max_val = par[ord]['VB']
            max_vb = ord
        if par[ord]['JJ'] == 1:
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


oppgave1()
