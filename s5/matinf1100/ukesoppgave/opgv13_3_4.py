import matplotlib.pyplot as plt
import numpy as np
def euler(a,b, n, x_0):
    h = 1.0*(b-a)/n
    
    x = [x_0]
    t = [h*i for i in range(n)]

    for i in range(1, n):
        dx= x[i-1] # function x' = x
        x.append(x[i-1] + h*dx)
        
    return t, x


t, x = euler(0,1,10,1)
plt.plot(t, x, 'r--')
plt.plot(t, np.exp(t), lw = 2) #exact solution
plt.show()

raw_input()

    
