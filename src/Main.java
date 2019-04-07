import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("How many nodes will form the tree?");
        Scanner scn = new Scanner(System.in);

        int numNodes = scn.nextInt();
        ArrayList<Integer>[] tree = new ArrayList[numNodes + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        int edges = numNodes - 1;

        while (edges-- > 0) {
            System.out.println("Tell me a parent");
            int parent = scn.nextInt();
            System.out.println("Who's his child?");
            int child = scn.nextInt();

            tree[parent].add(child);
        }

            System.out.println("Which pair of nodes do you want to find the nearest common ancestor?");
            System.out.println("Enter the first node:");
            int nodeA = scn.nextInt();
            System.out.println("Enter the second node:");
            int nodeB = scn.nextInt();

            findNearestCommonAncestor(1, tree, nodeA, nodeB);
            System.out.println("The nearest common ancestor is: " + nca);
    }

    static int nca = -1;

    public static boolean findNearestCommonAncestor(int node, ArrayList<Integer>[] tree, int nodeA, int nodeB) {

        boolean self = node == nodeA || node == nodeB ? true : false;

        int count = 0;

        for (int child : tree[node]) {
            if (findNearestCommonAncestor(child, tree, nodeA, nodeB)) {
                count++;
            }
        }

        if ((self && count == 1) || (count == 2)) {

            if (nca == -1) {
                nca = node;
            }
            return true;
        }
        return self || count == 1;
    }
}


