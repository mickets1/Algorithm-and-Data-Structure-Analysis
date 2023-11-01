import java.util.Arrays;
import uppgift1.LLNode;
import uppgift1.LinkedList;
import uppgift2.LLDeque;
import uppgift3.RndQueue;
import uppgift3.RndQueueIterator;
import uppgift4.AVLTest;
import uppgift4.AVLTree;
import uppgift4.BST;
import uppgift4.InBSTIterator;
import uppgift4.PostOrderIterator;
import uppgift4.PreBSTIterator;

public class App {
    public static void main(String[] args) throws Exception {
        //Uppgift 1
          // LinkedList ll = new LinkedList();
          
          // ll.append(1);
          // ll.append(2);
          // ll.append(3);
          // ll.append(4);
          // ll.append(5);

          // System.out.println(ll.getList().getVal());
          // System.out.println(ll.getList().getNxt().getVal());
          // System.out.println(ll.getList().getNxt().getNxt().getVal());
          // System.out.println(ll.getList().getNxt().getNxt().getNxt().getVal());
          // System.out.println(ll.getList().getNxt().getNxt().getNxt().getNxt().getVal());
          // System.out.println("length: " + ll.getLen() + "\n");

          // // Reverse LL & delete value 3.
          // ll.delete(3);
          // ll.reverseLL();
          // System.out.println(ll.getList().getVal());
          // System.out.println(ll.getList().getNxt().getVal());
          // System.out.println(ll.getList().getNxt().getNxt().getVal());
          // System.out.println(ll.getList().getNxt().getNxt().getNxt().getVal());
          // System.out.println("length:  " + ll.getLen());
        // End uppgift 1

        // Uppgift 2
          LLDeque<Integer> sq = new LLDeque<>();

          sq.addLast(1);
          sq.addLast(2);
          sq.addLast(3);
          sq.addFirst(5);
          sq.addFirst(6);
          sq.addLast(4);
          sq.removeFirst();
          sq.removeLast();

        for (Integer value : sq) {
          System.out.println(value);
        }
          System.out.println("\nLength: " + sq.getLen());
        // End uppgift 2

        // Uppgift 3
        //   RndQueue randomQueue = new RndQueue();
        //   randomQueue.enqueue(1);
        //   randomQueue.enqueue(2);
        //   randomQueue.enqueue(3);
        //   randomQueue.enqueue(4);
        //   randomQueue.enqueue(5);
        //   System.out.println("Dequeued value: " + randomQueue.dequeue());
        //   System.out.println("Queue size: " + randomQueue.size());

        //   System.out.print("Randomized order: ");
        //   for (int value : randomQueue) {
        //     System.out.print(value + " ");
        //   }

        //   System.out.println("\n\nDequeued elements in random order:");
        // while (!randomQueue.isEmpty()) {
        //     int dequeuedValue = randomQueue.dequeue();
        //     System.out.println(dequeuedValue);
        // }
        // End uppgift 3



        // uppgift 4

        //       4
        //     /   \
        //   2      5
        //  /\      /\ 
        // 1  3    6  7

        // BST t = new BST();

        // Inorder:

          // t.add(4);
          // t.add(2);
          // t.add(1);
          // t.add(3);
          // t.add(5);
          // t.add(6);
          // t.add(7);
          
          // t.add(8);
          // System.out.println(t.contains(8));
          // t.remove(8);
          // System.out.println(t.contains(8));

          // System.out.println("Tree height: " + t.height());

          // System.out.println("Removed: " + t.removeKthLargest(t, 3));

          // InBSTIterator inorderBST = new InBSTIterator(t.getRoot());

          // while (inorderBST.hasNext()) {
          //   System.out.println(inorderBST.next());
          // }

        // Preorder:

          // t.add(4);
          // t.add(2);
          // t.add(1);
          // t.add(3);
          // t.add(5);
          // t.add(6);
          // t.add(7);
          // System.out.println("Tree height: " + t.height());

          // System.out.println("Removed: " + t.removeKthLargest(t, 2));
                 
          // PreBSTIterator preorderBST = new PreBSTIterator(t.getRoot());

          // while (preorderBST.hasNext()) {
          //   System.out.println(preorderBST.next());
          // }

        // Post order:

          // t.add(4);
          // t.add(2);
          // t.add(1);
          // t.add(3);
          // t.add(5);
          // t.add(6);
          // t.add(7);

          // System.out.println("Tree height: " + t.height());
          // // Should throw exception:
          // System.out.println("Removed: " + t.removeKthLargest(t, 50));
                 
          // PostOrderIterator postorderBST = new PostOrderIterator(t.getRoot());

          // while (postorderBST.hasNext()) {
          //   System.out.println(postorderBST.next());
          // }


          // Uppgift 5
          // AVLTree avlt = new AVLTree();
          // avlt.add(3);
          // avlt.add(2);
          // avlt.add(2);
          // avlt.printPreOrder(avlt.getRoot());
          // avlt.add(1);
          // avlt.printPreOrder(avlt.getRoot());
          // System.out.println("Height: " + avlt.height());

          // AVLTest avlTest = new AVLTest();
          // avlTest.avlTest1();
          // System.out.println();
          // avlTest.bstTest1();
          // System.out.println();
          
          // avlTest.avlTest2();
          // System.out.println();
          // avlTest.bstTest2();
          
          
    }
}
