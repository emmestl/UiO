people = {}
class Person:
    def __init__(self, name):
        self.name = name
        self.hates = []
        self.friends = {}

    def add_hate(self, name):
        self.hates.append(name)

        if self.friends.has_key(name) and name.hates.count(self) == 0:
            self.friends[name] =1
        if name.hates.count(self) > 0:
            if self.friends.has_key(name):
                self.friends[name]  = 0
            if name.friends.has_key(self):
                name.friends[self] = 0



    def add_friends(self, name):
        self.friends[name] =0

        if self.hates.count(name) > 0 and name.hates.count(self) == 0:
            self.friends[name] = 1
        else:
            self.friends[name] = 0

    def getsum(self):
        return sum(self.friends.values())
        


            
def read_input(file_name):
    f = open(file_name, 'r')

    for line in f:
        file_in = line.split()
        if file_in[1] == 'hates':
            if not people.has_key(file_in[0]) :
                people[file_in[0]] = Person(file_in[0])
            if not people.has_key(file_in[2]) :
                people[file_in[2]] = Person(file_in[2])


            people[file_in[0]].add_hate(people[file_in[2]])


        elif file_in[0] == 'friends':
            if not people.has_key(file_in[1]) :
                people[file_in[1]] = Person(file_in[1])
            if not people.has_key(file_in[2]) :
                people[file_in[2]] = Person(file_in[2])


            people[file_in[1]].add_friends(people[file_in[2]])
            people[file_in[2]].add_friends(people[file_in[1]])

        else:
            print 'something wrong'
            return

    f.close()

def find_max():
    max = 0
    p = None
    
    for name in people:
        person = people[name]
        sum = person.getsum()
        if sum > max:
            max = sum
            p = name
    return p, max
    

read_input('e0bE4naA')
print find_max()
