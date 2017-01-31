# *-* encoding: utf-8 *-*
import nltk
from nltk.probability import ConditionalFreqDist

#oppgave 1
#byttte ut nltk.parse_cfg("") med nltk.CFG.fromstring(""), og nbest_parse(sent) med parse(sent) etter tips fra piazza

grammar = nltk.CFG.fromstring("""
S -> NP VP
VP -> V NP PP | V NP NP |V  |V NP
PP -> P NP
NP -> "Per" | "Kari" | "Ola" | "boka" | "middag" | D N
V -> "gir" | "spiser" | "sover" | "finner"
D -> "en"
N -> "bok"
P -> "til"
""")

sent = [ "Per gir en bok til Kari" , "Kari gir Per boka", "Ola sover" , "Kari spiser" , "Kari spiser middag", "Per finner boka","Kari sover boka", "Ola finner"]

rd_parser = nltk.RecursiveDescentParser(grammar)
for sentence in sent:
    for tree in rd_parser.parse(sentence.split()):
        print tree


print '\n'

#endret grammatikken slik at ulovlige steninger ikke skal fårekomme, men dette fører til at Tagsene vil ha litt andre verdier.
grammar = nltk.CFG.fromstring("""
S -> NP VP
VP -> DTV NP PP | DTV NP NP |IV  |TV NP
PP -> P NP
NP -> "Per" | "Kari" | "Ola" | "boka" | "middag" | D N
V ->  TV | DTV
IV -> "spiser" | "sover" 
TV -> "spiser" | "finner"
DTV -> "gir" | "finner"
D -> "en"
N -> "bok"
P -> "til"
""")
#IV intransitive verb (bare subject)
#TV transitive verb (subject og direkte objekt)
#DTV ditransitive verbs (subjekt, direkte objekt og indirekte objekt)


sent = [ "Per gir en bok til Kari" , "Kari gir Per boka", "Ola sover" , "Kari spiser" , "Kari spiser middag", "Per finner boka", "Kari sover boka", "Ola finner"]

rd_parser = nltk.RecursiveDescentParser(grammar)
for sentence in sent:
    for tree in rd_parser.parse(sentence.split()):
        print tree


"""
Ser at den første grammatikken laget ut av de setningen vi så på som lovlige så kan også de to ulovlige generes, mens i gramatikk nr 2 hvor vi har endret på verbene og laget en finere inndeling der er plutselig ikke dette mulig lenger. 


"""
        

"""
oppgave 2

1. But questions with which committee members taunted bankers appearing as witnesses left little doubt that they will recommend passage of it.
-leave#3 (act or be so as to become in a specified stated)


2. The departure of the Giants and the Dodgers to California left New York with only the Yankees.
-leave#11 (have left or have as a remainder)


3. After the coach listed all the boy’s faults , Hartweger said, “Coach before I leave here , you ’ll get to like me”.
-leave#8 (remove oneself from an association with or praticipation)


4. R.H.S. Crossman , M.P., writing in The Manchester Guardian, states that departures from West Berlin are now running at the rate not of 700, but of 1700 a week, and applications to leave have risen to 1900 a week.
-leave#5 (move out of or depart from)


5. The house has been swept so clean that contemporary man has been left with no means, or at best with wholly inadequate means, for dealing with his experience of spirit .
-leave#2 (go and leave behind, either intentionally or by neglect or forgetfulness)



- Jeg synes setning 2 og 5 var vanskelig å skille og dermed også de vanskligste å bestemme. 3 og 4 var også ganske vanskelig å separere så dermed også litt vanskelige å bestemme en betydning til. Grunnen til at det var disse som var de vanskligste parrene var at de hadde så lik leave så små ting som skilte dem.Men den enkelt setningen jeg synes var vanskeligst var nr 3, hvor jeg følte leave#1, #5 og #8 alle passet.

- Jeg synes verb-groupen til leave#1-leave#5 var vanskelig å skille det jeg brukte til å skille dem var eksempelsetningene og at leave#5 også hadde betydningen exit som ikke leave#1 hadde. På setning nr 4 landet jeg på leave#5 fordi jeg følte beskrivelsen "move out or depart from"  i mye større grad representerte betydningen av leave enn "go away from a place".
"""
print '\n'

#oppgave 3

f = open('wsd_tren.txt', 'r')
data = ConditionalFreqDist()
counter = [0, 0 , 0 , 0]

for line in f:
    categorie = line.split()[0]
    line = line.split()
    for i in range(len(line)):
        if i == 0: continue
        data[categorie][line[i]] += 1
        
    counter[0] += 1 #alle kategoriene
    if categorie == 'Reading':
        counter[1] += 1 #antall reading
    if categorie == "Removing":
        counter[2] += 1 #antall removing
    if categorie == "Self_motion":
        counter[3] += 1 #antall self_motion

p_REMOVING = counter[2]*1.0/counter[0]
p_day_READING = data['Reading']['day']*1.0 / counter[1]

print 'P(REMOVING) = ', p_REMOVING
print 'P(day|READING) = ', p_day_READING


names = ["Reading", "Removing", "Self_motion"]
probs = [0, 0, 0] #Reading, Removing, Self_motion
highest = 0.0
most_L = 0

for i in range(len(probs)):
    probs[i] = (1.0*counter[i+1]/counter[0]) * (1.0*data[names[i]]['paper']/counter[i+1])* (1.0*data[names[i]]['surface']/counter[i+1])*(1.0*data[names[i]]['towards']/counter[i+1])
    if probs[i] > highest:
        most_L = i

print 'Den mest sannsynlige kategorien er: ', names[most_L]

f.close()


"""
Så først helt på slutten at jeg kunne lest inn filen for å slippe å hardkode inn verdiene i den site deloppgaven, men ettersom jeg antar at det ikke gjorde noe stor forskjell valgte jeg å la det stå som det er nå. 
"""
