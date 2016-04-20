import nltk

ord_tag = nltk.corpus.brown.tagged_words()
unike_ord = {}
unike_ord_not_sensitive = {}

for ord, tag in ord_tag:
    ord_none = ord.lower()
    unike_ord = check(unike_ord, ord)
    unike_ord_not_sensitive = check(unike_ord_not_sensitive, ord_none)
    
count = 0
hapax_klasser = {}
hapax_klasser_not = {}

for value in unike_ord.values():
    if(isinstance(value, basestring)):
        count += 1
        if(hapax_klasser.get(value) == None):
            hapax_klasser[value] = 0
        else:
            hapax_klasser[value] += 1

#finding max
maks = 0
klasse = None

for i in hapax_klasser.keys():
    if maks < hapax_klasser.get(i):
        maks = hapax_klasser.get(i)
        klasse = i


print count, ' ord hapax legiogram'
print len(hapax_klasser), ' ordklasser inneholder hapax'
print klasse, 'inneholder' , maks, 'hapax'


def check(dic, ord):
    if(dic.get(ord) == None):
        dic[ord] = tag
    elif(isinstance(dic.get(ord), basestring)):
        dic[ord] =  1
    else:
        dic[ord] += 1
    return dic
