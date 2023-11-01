public class App {
    public static void main(String[] args) {
        TimeIt time = new TimeIt();

        // Brute force threeSum
        // ThreeSum threeSum = new ThreeSum();
        // time.threeSum(threeSum);

        // ThreeSumPointer threeSumPointer = new ThreeSumPointer();
        // time.threeSumPointer(threeSumPointer);

        // Union find
        // QUnionFind union = new QUnionFind();
        // time.calculateQuf(union);

        // Weighted union quick find
        WQUnionFind wuqf = new WQUnionFind();
        time.calculateWuqf(wuqf);
    }
}
