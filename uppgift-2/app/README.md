# Analysis of AVL Trees VS Binary Search Trees
The AVLTest.java class were used to conduct the tests.

## Test1  
### Random insertions:  
AVLTest1():  
    With 100_000 randomized insertions(no deletes) we end up with around 63100 nodes.  
    The worst case or maximum height would be: 1.44 * log2 63100 - 1.328 = 1.44 * 15.945 - 1.328 = 21,6328
    While the observed mean height was ~13.

    Example: 
    Height: 18
    Nodes: 63279
    Mean: 13.24098
    Execution time: 0.058416995 seconds

bstTest1():  
    The same test as above takes quite a bit longer to run due to the time complexity for insertion depends on the trees depth.  
    Compared to the Balanced AVLTree where the time complexity is always O(log n) and we can avoid unbalanced trees and "degenerate trees" which would increase the time complexity for operations to O(n).  
    The height for 50363 nodes is around 30 with a mean of 27, varying to a height of 38 for a node count of ~63000 and a mean of 28.

    Example:
    Height: 40
    Nodes: 63103
    Mean: 28.981602
    Execution time: 44.17449204 seconds

#### Conclusion:
The result shows that the advantage of AVL trees over BSTs in maintaining tree balance which result in more efficient insertions and performance.

----

## Test2  
### Random insertions and deletions:  
After 100_000 insertions and deletions the AVL tree had a height of 18 with a mean height of ~16.  
This indicates that the AVL tree rebalanced itself after insertions and deletions.

AVLTest2():
    Example:
    Height: 18
    Nodes: 52724
    Mean: 16.095972
    Execution time: 0.074436827 seconds

The BST's height increased to ~36 with a mean height of ~33.
This shows thats its harder for a BST to maintain balance compared to AVL trees.

bstTest2():
    Example:
    Height: 36
    Nodes: 50268
    Mean: 33.451202
    Execution time: 36.255260011 seconds


#### Conclusion:  
The result of the experiment align with the expectations of AVL trees performing better in scenarios involving dynamic operations such as the insertions and deletions. The AVL trees consistently shows lower tree height and mean height.
For applications that require frequent dynamic operations AVL trees is a better choice over BST's.

