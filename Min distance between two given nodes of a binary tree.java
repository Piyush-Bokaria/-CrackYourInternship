//Day 43 of #CrackYourInternship
class GfG {
    private Node lowestca(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }
        Node left = lowestca(root.left, a, b);
        Node right = lowestca(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    private int distance(Node root, Node target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            return 0;
        }
        int left = distance(root.left, target);
        int right = distance(root.right, target);
        if (left >= 0) {
            return left + 1;
        }
        if (right >= 0) {
            return right + 1;
        }
        return -1;
    }

    private Node findNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        }
        Node left = findNode(root.left, value);
        return (left != null) ? left : findNode(root.right, value);
    }

    int findDist(Node root, int a, int b) {
        Node nodeA = findNode(root, a);
        Node nodeB = findNode(root, b);
        Node lca = lowestca(root, nodeA, nodeB);
        return distance(lca, nodeA) + distance(lca, nodeB);
    }
}
