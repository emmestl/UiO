# *-* encoding: utf-8 *-*
import nltk

def max_analysis(brown_stuff):
    max_word = None
    max_nr = 0
    for word, nr in brown_stuff.items():
        if (max_nr < nr):
            max_word = word
            max_nr = nr
    return max_word, max_nr



def min_analysis(brown_stuff):
    min_word = None
    min_nr = 0
    for word, nr in brown_stuff.items():
        if (min_nr > nr or min_word == None):
            min_word = word
            min_nr = nr
    return min_word, min_nr



def ambiguous_word(word_set):
    ambig_words = 0

    max_amb = None
    max_nr = 0
    
    for word in word_set.keys():
        if(len(word_set.get(word)) > 2):
            ambig_words += 1
        if(len(word_set.get(word)) > max_nr):
            max_amb = word
            max_nr = len(word_set.get(word))
            
    return (ambig_words, max_amb, max_nr)
        

def freqs(w):
    w_tag = {}
    for word, tag in brown:
        word = word.lower()
        if(w == word):
            if(w_tag.get(tag) == None):
                w_tag[tag] = 0
            w_tag[tag] += 1

    return w_tag



brown = nltk.corpus.brown.tagged_words(categories="news")

different_word = {} #key is word value is number of occurance
different_tags = {} #key is tag value is number of occurance
word_set = {} #key is word value is set of tags

for word, tag in brown:
    word = word.lower()

    
    if(different_word.get(word)== None):
        different_word[word] = 0
        word_set[word] = set()
        
    different_word[word] += 1
    word_set[word].add(tag)
       
    if(different_tags.get(tag) == None):
        different_tags[tag] = 0
    
    different_tags[tag] += 1

    

print 'most frequent word is: ', max_analysis(different_word)[0]
print 'most frequent tag is: ', max_analysis(different_tags)[0]
print 'least frequent tag is: ', min_analysis(different_tags)[0]


#[0] = total nr, [1] = most ambig word, [2] = |most ambig word|
ambig_analasys = ambiguous_word(word_set) 
print 'number of ambiguous word is: ' , ambig_analasys[0]
print 'most ambiguous word is: ' , ambig_analasys[1]
print 'most ambiguous word nr of different occurances: ' , ambig_analasys[2]



#NOTE: gidder ikke lese inn fra terminal så må endre ordet som har blit hardkodet her:
word = 'run'
print word, ' frequence as follows ', freqs(word)
print 'the most ambiguous word ', ambig_analasys[1], ' frequence as follows ', freqs(ambig_analasys[1])


#ser at to forekommer i all hovedsak i lukkede ordklasser. Bare en forekomst i NPS
