import numpy as np

def derr(h):
    df = (np.exp(1+h) - np.exp(1-h))/(2*h)
    return df

df = 1
h = 0.001
while (abs(df-np.exp(1)) > 10**(-18) and df != 0):
    df =  derr(h)
    print df, h
    h = h/10
