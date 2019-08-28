import java.util.LinkedList;
import java.util.Queue;

public class Practice1 {

    //判断是否是平衡二叉树
    public static boolean isComplete(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            TreeNode front = queue.poll();
            if(front == null){
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                return false;
            }
        }
        return true;
    }
}
