import math
import numpy as np
print math.pi/12 *sum([(np.sin(math.pi/24 + i*math.pi/12))/(1 + (math.pi/24 + i*math.pi/12)**2) for i in range(6)])
