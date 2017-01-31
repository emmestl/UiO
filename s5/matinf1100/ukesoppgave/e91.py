import matplotlib.pyplot as plt
import numpy as np

def c(xp, yp):
    c = []
    l = len(xp)

    for k in range(l):
        c.append(yp[k])
        prod = 1
        for n in range(k):
            c[k] -= c[n]*prod
            prod *= (xp[k] - xp[n])
        c[k] /= prod

    return c

def p_n(x, xp, c):
    value = []
    l = len(x)
    m = len(xp)
    
    for k in range(l):
        value.append(xp[0])

        prod = 1
        for n in range(m):
            prod *= (x[k] - xp[n])
            value[k] += c[n]*prod
            if prod == 0:
                break

    return value

def compare_f():
    t = np.arange(0.0, 1.0, 0.01)
    n = 10.0
    xp1 = [0, 1/n]
    xp2 = [i/n for i in range(2)]
    xp3 = [i/n for i in range(3)]
    xp4 = [i/n for i in range(4)]

    plt.figure(1)
    plt.subplot(211)
    plt.plot(t, t**3, lw = 2)
    plt.plot(t, p_n(t, xp1, c(xp1, [i**3 for i in xp1])), 'r--' )
    plt.plot(t, p_n(t, xp2, c(xp2, [i**3 for i in xp2])), 'g--' )

    plt.subplot(212)
    plt.plot(t, t**3, lw = 2)
    plt.plot(t, p_n(t, xp3, c(xp3, [i**3 for i in xp3])), 'r--' )
    plt.plot(t, p_n(t, xp4, c(xp4, [i**3 for i in xp4])), 'g--' )

    plt.show()    
    raw_input()

compare_f()    

