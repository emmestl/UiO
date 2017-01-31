import numpy as np

def a(x):
    return x - np.sqrt(3)


def b(x):
    return x - 2**(1.0/12)


def c(x):
    return x - np.exp(1)

def secant(a, b, f, error):

    x_p  = b*1.0
    x_pp = a*1.0

    while(abs(x_p - x_pp) >= abs(error*x_p)):
        x = -f(x_pp)*(x_p-x_pp)/(f(x_p) - f(x_pp)) + x_pp
        x_pp = x_p
        x_p = x

    return x_p


print '2 correct digits'
print secant(0, 1, a, 10**(-2))
print secant(0, 1, b, 10**(-2))
print secant(0, 1, c, 10**(-2))

print '15 correct digits'
print secant(0, 1, a, 10**(-15))
print secant(0, 1, b, 10**(-15))
print secant(0, 1, c, 10**(-15))
