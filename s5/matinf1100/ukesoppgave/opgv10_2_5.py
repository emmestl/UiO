import numpy as np
def bisection(a, b, n):

    for i in range(n):
        x = 1.0*(a+b)/2
        fx = np.sin(x)
        fa = np.sin(a)
        if (fx == 0):
            return fx
        elif fx*fa < 0:
            b = x
        else:
            a = x
        
    return fx

print bisection(-1,20, 34)
