import numpy as np
import matplotlib.pyplot as plt

def euler(a,b,n, x_vec_0):
    h = 1.0*(b-a)/n

    t = [a + i*h for i in range(n+1)]
    x_1 = [x_vec_0[0]]
    x_2 = [x_vec_0[1]]
    y_1 = [x_vec_0[2]]
    y_2 = [x_vec_0[3]]

    for i in range(n):
        dx = [x_2[i], 2*y_1[i] - np.sin(4*t[i]**2*x_1[i]), y_2[i], -2*x_1[i] - 1.0/(2*t[i]**2*x_2[i]**2 +3)]
        x_1.append(x_1[i] + h*dx[0])
        x_2.append(x_2[i] + h*dx[1])
        y_1.append(y_1[i] + h*dx[2])        
        y_2.append(y_2[i] + h*dx[3])


        print x_1[1+i], x_2[i+1], y_1[i+1], y_2[i+1]
    return t, x_2, y_2


t, x, y = euler(0, 2, 2, [1, 2, 1, 0])
print x
print
print y

plt.plot(t, x, lw = 2)
plt.plot(t, y, lw = 2)
plt.show()
raw_input()
