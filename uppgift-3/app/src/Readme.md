# Uppgift 2 report

# Results:

Based on the following test data we can observe how well the hash function performs and draw some conclusions: 

Table is half-full  
Value to find: HPM393  
Found?: true  
Table length: 15  
Average collisions per insertion: 0.25806451612903225  
Max collisions for a single insertion: 3  
Total collisions: 9  

When the hashtable gets half-full the execution is stopped to prevent overloading.  
The registration number was found in the hash table.
The lenght of the hash table was 15.
The average number of collisions per insertion was ~0.26 which shows that collisions were not very common and the hash function performed pretty good.
The maximum collisions for a single insertion was 3 which is also reasonable.
9 collisions occured for this specific test run.(it fluctuates between 9 - 15)

The results shows efficiency and performance due to the use of quadratic probing. Low average collisions shows that most insertions were made without collisions and the maximum collision count is managable.

# Uppgift 5 report
For smaller input sizes(5 - 15) insertsort is chosen(and performs better) and in this case it switches to heapsort with a input size of ~50. a depth value of 4 - 7 seem ok in this experiment.
For "larger" input sizes heapsort outperforms insersort.