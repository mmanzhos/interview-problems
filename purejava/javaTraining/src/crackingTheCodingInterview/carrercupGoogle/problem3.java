/*
https://en.wikipedia.org/wiki/Tree_traversal

http://www.careercup.com/question?id=5682612859305984
<p>Post order traversal for an N-ary tree iterative way.
<br>Given,
<br>struct Node {
<br>   int val;
<br>   vector<Node*> children;
<br>};
<br>
<br>Without modifying original structure.</p>

My thoughts:
recursive solution for Binary tree is pretty trivial,
and here it is needed to understand how any tree should be iterated in postorder.
https://en.wikipedia.org/wiki/Tree_traversal#/media/File:Sorted_binary_tree_postorder.svg

so we can start basic approach:
1. go the leftmost node's child and add every passed node to the stack
2. if node has not children visit it
3. and go 1 node up by using node = stack.pop()
4. now it is important to track which child of node we have alredy visited and visit next one until of them are visited

Another approach (from carrecup topic):
make a trick
go with usual bfs, but with usage of stack
and add each processed node to the linkedlist at the first index like list.addFirst(node)
PROFIT!
so process is made vice-versa, but thanks to .addFirst trick result is correct,
we can consider it like moving to the right and to the bottom
rather than to the bottom and to the right like I mistakenly did.


Pseudo-code:
stack stack
stack push root
node node = root
set visited = new set
while stack is NOT empty

  foundUnvisited = false;
  // children must be accessible in order (hashmap is not okay, arraylist/linkedlist is OK
  for (node c : node.children)
    if c is not visited
      if node != root
        stack push node
      node = c
      foundUnvisited = true
      break
  
   if (children.isempty OR foundUnvisited == false)
    visited add node
    visit(node)
    node = stack.pop

*/



class TreeNode {
    int val;
    ArrayList<TreeNode> children;
}

public class Main {
    
    // my code which doesn't show root at the end :(
    public void dfsPorstorder(TreeNode root) {
        if (root == null) return;

        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<TrreNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();

        stack.push(new TreeNode(Integer.MIN_VALUE));
        stack.push(root);

        while (!stack.isEmpty()) {
            if (currentNode.val == Integer.MIN_VALUE)
                return;

            TreeNode currentTmp = currentNode;

            boolean foundUnvisited = false;
            for (TreeNode child : currentNode.children) {
                if (!visited.contains(child)) {
                    if (currentNode.val != root.val) {
                        stack.push(currentNode);
                    }
                    currentNode = child;
                    foundUnvisited = true;
                    break;
                }
            }

            if (currentTmp.children.size() == 0 || !foundUnvisited) {
                visited.add(currentNode);
                visit(currentNode);
                currentNode = stack.pop();
            }
        }


    }


    // concise and perfect code found on carrecup topic
    public static List<TreeNode> getPostOrder(TreeNode root){
        LinkedList<TreeNode> results = new LinkedList<TreeNode>();
        if(root == null){
            return results;
        }

        Stack<TreeNode> unprocessed = new Stack<TreeNode>();
        unprocessed.push(root);
        while(!unprocessed.isEmpty()){
            TreeNode node = unprocessed.pop();
            results.addFirst(TreeNode);
            for(TreeNode childTreeNode : node.children){
                unprocessed.push(childTreeNode);
            }
        }
        return results;
    }


}