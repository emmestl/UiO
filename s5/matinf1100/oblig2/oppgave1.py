# *-* encoding: utf-8 *-*
import matplotlib.pyplot as plt

"""
finner en tilnærmet funksjon for akselerasjonen. Hvor hver verdi er gitt ved.
f'(a) = (f(a+h) - f(a))/h
"""
def akselerasjon(t, v):
    a=[0]
    for i in range(1, len(v)):
        h = t[i] - t[i-1]
        a.append((v[i] - v[i-1])/h)

    return a


"""
finner en tilnærmet funksjon for strekningen.
"""
def strekning(t, v):
    s = [0]

    for i in range(1, len(v)):
        h = t[i]-t[i-1]
        s.append(s[i-1] + v[i]*h)
        
    return s



t = []
v = []
infile = open('running.txt', 'r')
for line in infile:
    tnext, vnext = line.strip().split(',')
    t.append(float(tnext))
    v.append(float(vnext))

infile.close()


plt.figure(1)

plt.subplot(211)
plt.plot(t, akselerasjon(t, v),  lw = 2)

plt.subplot(212)
plt.plot(t, strekning(t, v),  lw = 2)

plt.savefig("opgv1")
plt.show()

raw_input()
