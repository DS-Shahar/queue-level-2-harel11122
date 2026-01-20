

    public static void printSpecialNodes(Node root) {
        if (root == null) return;
        if (root.value % 2 == 0) {
            boolean leftOk = (root.left == null || root.left.value % 2 == 0);
            boolean rightOk = (root.right == null || root.right.value % 2 == 0);
            if (leftOk && rightOk && (root.left != null || root.right != null)) {
                System.out.println(root.value);
            }
        }
        printSpecialNodes(root.left);
        printSpecialNodes(root.right);
    }

    public static int countSpecialNodes(Node root) {
        if (root == null) return 0;
        int count = 0;
        if (root.value % 2 == 0) {
            boolean leftOk = (root.left == null || root.left.value % 2 == 0);
            boolean rightOk = (root.right == null || root.right.value % 2 == 0);
            if (leftOk && rightOk && (root.left != null || root.right != null)) {
                count = 1;
            }
        }
        return count + countSpecialNodes(root.left) + countSpecialNodes(root.right);
    }

    public static boolean existsSpecialNode(Node root) {
        if (root == null) return false;
        if (root.value % 2 == 0) {
            boolean leftOk = (root.left == null || root.left.value % 2 == 0);
            boolean rightOk = (root.right == null || root.right.value % 2 == 0);
            if (leftOk && rightOk && (root.left != null || root.right != null)) {
                return true;
            }
        }
        return existsSpecialNode(root.left) || existsSpecialNode(root.right);
    }

    public static boolean allNodesSpecial(Node root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        boolean leftOk = (root.left == null || root.left.value % 2 == 0);
        boolean rightOk = (root.right == null || root.right.value % 2 == 0);
        boolean currentOk = (root.value % 2 == 0 && leftOk && rightOk);
        return currentOk && allNodesSpecial(root.left) && allNodesSpecial(root.right);
    }
}
