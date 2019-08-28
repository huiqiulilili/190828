import java.util.*;

public class Practice2 {

    public static TreeNode buildTree() {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = null; d.right = null;
        e.left = null; e.right = h;
        f.left = null; f.right = null;
        g.left = null; g.right = null;
        h.left = null; h.right = null;

        return a;
    }
    //树的层序遍历
//    public static void stree(TreeNode root){
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            TreeNode front = queue.poll();
//            System.out.println(front.val);
//            if(front.left != null){
//                queue.add(front.left);
//            }
//            if(front.right != null){
//                queue.add(front.right);
//            }
//        }
//    }

    public static class Element{
        int level;
        TreeNode node;
    }
    public static List<List<Character>> trees(TreeNode root){
        List<List<Character>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<Element> queue = new LinkedList<>();
        Element e = new Element();
        e.level = 0;
        e.node = root;
        queue.add(e);
        while(!queue.isEmpty()){
            Element front = queue.poll();
            if(front.level == list.size()){
                list.add(new ArrayList<>());
            }
            list.get(front.level).add(front.node.val);
            if(front.node.left != null){
                Element l = new Element();
                l.node = front.node.left;
                l.level = front.level + 1;
                queue.add(l);
            }
            if(front.node.right != null){
                Element r = new Element();
                r.node = front.node.right;
                r.level = front.level + 1;
                queue.add(r);
            }
        }
        return list;
    }

    //向下调整，堆化

    /**
     * 前提：除了需要调整的下表外，都满足堆概念
     * @param array
     * @param size
     * @param index
     */
    public static void heapity(int[] array,int size,int index){
        while(true) {
            int left = index * 2 + 1;
            if (left >= size) {
                return;
            }
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if (array[max] > array[index]) {
                swap(array, max, index);
            }
            index = max;
        }
    }

    //创建一个堆
    public static void createdHeap(int[] array,int size){
        int parent = (size - 2) / 2;
        for(int i = parent;i >= 0;i --){
            heapity(array,size,i);
        }
    }



    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
//        stree(buildTree());
        System.out.println(trees(buildTree()));
    }
}
