import matplotlib.pyplot as plt
import numpy as np
import math


def derfunc(x):
    return -4*math.pow(x,3) + 6*math.pow(x,2) +4*x -1

def func(x):
    return -1*math.pow(x, 4) + 2*math.pow(x,3) + 2*math.pow(x, 2) -1*x

x = np.linspace(-2, 3, 1000)
vp= np.vectorize(func)
vpd = np.vectorize(derfunc)
yd = vpd(x)
y = vp(x) 

plt.plot(x, y, '-')
plt.plot(x, yd, '.')
plt.show()
