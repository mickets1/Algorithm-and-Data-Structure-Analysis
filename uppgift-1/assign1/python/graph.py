from scipy.optimize import curve_fit
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import seaborn as sns

# Graph of 3sum with pointers
def threesumpointer():
  df = pd.read_csv('data/3sum_pointer.csv')
  sns.scatterplot(x='sz', y='time', data=df)
  plt.title('3sum pointer - Array length 100 to 1000')
  plt.xlabel('Array length')
  plt.ylabel('Average time (seconds)')
  plt.show()

#Threesum brute-force
def threesum():
  df = pd.read_csv('data/3sum_brute_force.csv')
  sns.scatterplot(x='sz', y='time', data=df)
  plt.title('3sum brute force - Array length 100 to 1000')
  plt.xlabel('Array length')
  plt.ylabel('Average time (seconds)')
  plt.show()

def weightedQuickUnionFind():
  df = pd.read_csv('data/wquf.csv')
  sns.scatterplot(x='sz', y='time', data=df)
  plt.title('Weighted quick union find 10000 - 100000 unions')
  plt.xlabel('Number of unions')
  plt.ylabel('Average time (seconds)')
  plt.show()

def quickunionfind():
  df = pd.read_csv('data/quf.csv')
  sns.scatterplot(x='sz', y='time', data=df)
  plt.title('Quick union find 10000 - 100000 unions')
  plt.xlabel('Number of unions')
  plt.ylabel('Average time (seconds)')
  plt.show()

def compute3sumBruteforceModel():
  df = pd.read_csv('data/3sum_brute_force.csv')
  [(a3, b3), _] = curve_fit(powmod, df.sz, df.time)

  sns.lineplot(x=df.sz, y=2**-25.86*df.sz**2.93, label=f'computed model (a={2**-25.86:.3e}, b=2.93)')
  sns.lineplot(x=df.sz, y=a3*df.sz**b3, label=f'fitted model (a={a3:.3e}, b={b3:.3f}')
  
  sns.scatterplot(x='sz', y='time', data=df)
  plt.title('Brute force 3sum on arrays of length 100 \u2013 1000')
  plt.xlabel('length')
  plt.ylabel('time (seconds)')
  plt.show()


def powmod(x, a, b):
    return a * x ** b

def compute3sumPointerModel():
  df = pd.read_csv('data/3sum_pointer.csv')
  [(a3, b3), _] = curve_fit(powmod, df.sz, df.time)

  sns.lineplot(x=df.sz, y=2**-24.62*df.sz**1.81, label=f'computed model (a={2**-24.62:.3e}, b=1.81)')
  sns.lineplot(x=df.sz, y=a3*df.sz**b3, label=f'fitted model (a={a3:.3e}, b={b3:.3f}')
  
  sns.scatterplot(x='sz', y='time', data=df)
  plt.title('Brute force 3sum on arrays of length 1000 \u2013 10000')
  plt.xlabel('length')
  plt.ylabel('time (seconds)')
  plt.show()



#computeBruteforceModel()
#compute3sumPointerModel()
#threesumpointer()
#threesum()
#quickunionfind()
weightedQuickUnionFind()