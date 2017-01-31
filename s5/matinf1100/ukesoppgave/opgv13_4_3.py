import numpy as np
import matplotlib.pyplot as plt

def euler(a, b, n, x_0):
    h = 1.0*(b-a)/n
    t = [a + i*h for i in range(n+1)]
    x = [x_0*1.0]

    for i in range(n):
        dx = -x[i]*np.sin(t[i]) +np.sin(t[i])
        x.append(x[i] + h*dx)
    return t, x

def euler_midpoint(a,b,n,x_0):
    h = 1.0*(b-a)/n
    t = [a + i*h for i in range(n+1)]
    x = [x_0*1.0]

    for i in range(n):
        dx = -x[i]*np.sin(t[i]) +np.sin(t[i])
        x_half = x[i] + h/2*dx
        dx = -x_half*np.sin(t[i]+h/2) +np.sin(t[i]+h/2)
        x.append(x[i] + h*dx)
    return t, x

plt.figure(1)
j = 221
for i in [1,2,5,10]:
    plt.subplot(j)
    t_1, x_1 = euler(0, np.pi, i, 2+np.exp(1))
    plt.plot(t_1, x_1, lw = 2)
    t_2, x_2 = euler_midpoint(0, np.pi, i, 2+np.exp(1))
    plt.plot(t_2, x_2, lw = 2)
    j += 1
plt.show()
raw_input()
    
