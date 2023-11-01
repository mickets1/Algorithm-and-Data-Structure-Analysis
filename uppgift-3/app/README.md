When using unique randomly generated registration numbers and an array length of 31 i get roughly around 10 - 20 collions. I decided to deny insert when the table gets half full. We can also continue to try buckets and the collions increase to roughly tenfold, assuming the array doesn't get full and an exception is thrown.


The reason for using an alternative sorting algorith to Quicksort is to avoid the worst-case time of O(N^2). Assuming we have a optimal pivot point using the median of three we would want to switch to Heapsort when the time complexity reaches(or exceeds) O(n log n) as it's the worst running time of heapsort(faster than quicksorts worst case). According to my research a good value for the depth parameter is log2 of the length of the array, we decrease this value to count number of recursions.

Worst case for insert sort is O(n^2). Insert sort works best for small arrays, according to Wikipedia this is somewhere between 7 - 50 elements.