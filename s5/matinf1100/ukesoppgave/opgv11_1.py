import math
import numpy as np
from decimal import Decimal

def derr_ex(a, h):
    #f'(a) = (f(a+h) - f(a))/h
    return (math.exp(a+h)-math.exp(a))/h
    

def error(a, h):
    return 2*(math.exp(a) - derr_ex(a, h))

a= 1.0
for k in range(1,15):
    print "10^-{:2} | {:.20f} | {:.2E}".format(k, derr_ex(a, 10**(-k)), Decimal(abs(error(a, 10**(-k)))))
