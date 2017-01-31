import numpy as np

def trapeziod(a,b,n):
    integral = (np.exp(a) + np.exp(b))/2
    h = 1.0/n
    
    for i in range(1, n):
        integral += np.exp(h*i)

    integral *= h

    return integral


def midpoint(a, b, n):
    h  = 1.0/n
    integral = 0
    pos = h/2
    for i in range(n):
        integral += np.exp(pos)
        pos += h

    integral *= h
    return integral

    
n = 37800
integral = 0
correct = np.exp(1) - 1
error = 1
while(error > 10**(-10)):
    n+=1
    integral = trapeziod(0,1,n)
    error = abs(integral - correct)

print n, error ,integral




integral = midpoint(0,1,n)
print n, abs(integral - correct), integral
