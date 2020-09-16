import numpy as np
a=np.arange(12).reshape(4,3)
b=a>5
c=a[b]
d=c.reshape(2,3)
print (d)
print (d[0,1:])
