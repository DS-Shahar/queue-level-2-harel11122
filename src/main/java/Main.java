

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

    public static int ex12(BinNode<Integer> T)
{
        if (T == null)
            return 0;


        if (10<=T.getValue()&&T.getValue()<100&&T.hasRight()&&T.hasLeft()){
            return ex12(T.getLeft()) + ex12(T.getRight())+1;}
        else{    
            return ex12(T.getLeft()) + ex12(T.getRight());}
    }


    public static int ex14(BinNode<Integer> T)
{
        if (T == null)
            return 0;


        if (!T.hasRight()&&!T.hasLeft()){
            return ex14(T.getLeft()) + ex14(T.getRight())+1;}
        else{    
            return ex14(T.getLeft()) + ex14(T.getRight());}
    }
   
   
     public static int ex16(BinNode<Integer> T)
{
        if (T == null)
            return 0;


        if (T.hasRight()&&T.hasLeft()){
            return ex16(T.getLeft()) + ex16(T.getRight())+T.getValue();}
        else{    
            return ex16(T.getLeft()) + ex16(T.getRight());}
    }
   
   
     public static int ex17(BinNode<Integer> T)
{
        if (T == null)
            return 0;
       
        int Count = 0;

      if (T.hasRight()&&T.hasLeft()){

       boolean leftOk =T.getLeft().hasRight()||T.getLeft().hasLeft();
       boolean rightOk=T.getRight().hasRight()||T.getRight().hasLeft();
       
        if (leftOk&&rightOk){
            Count=1;}}
         
           
    return Count+ex17(T.getLeft()) + ex17(T.getRight());}
    }
}
