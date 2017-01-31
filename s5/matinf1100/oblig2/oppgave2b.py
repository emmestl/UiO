import matplotlib.pyplot as plt
import numpy as np
from math import sqrt

def euler(a, b, n, x_0): #intervall [a,b], n steg
    h = 1.0*(b-a)/n
    t = [a + i*h for i in range(n+1)]
    x = [x_0*1.0]

    for i in range(n):
        dx = 1 - x[i]**2
        x.append(x[i] + h*dx)
    return t, x


def analytisk(t):
    e =[(np.exp(2*i) - 1)/(np.exp(2*i) + 1) for i in t]
    return e


def euler_mid(a, b, n, x_0):
    h = 1.0*(b-a)/n
    t = [a + i*h for i in range(n+1)]
    x = [x_0*1.0]

    for i in range(n):
        dx = 1 - x[i]**2
        x_half = x[i] + (h/2)*dx
        dx = 1 - x_half**2
        x.append(x[i] + h*dx)
    return t, x

    

t,x = euler(0,2,5,0)
eulers, = plt.plot(t,x, label = 'Eulers metode', lw=2)
t = np.arange(0.0, 2.0, 0.01)
analytic, = plt.plot(t, analytisk(t), label = 'Analytisk', lw =2)
t,x = euler_mid(0,2,5,0)
euler_mid, = plt.plot(t,x, label = 'Euler midtpunkt', lw = 2)

plt.legend(handles = [eulers, analytic, euler_mid], loc = 'best')
plt.savefig("opgv2")
plt.show()
raw_input()
