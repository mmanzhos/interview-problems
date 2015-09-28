package trees;

public class RedBlack {

	RBNode root;
	
	enum NodeColor {
		RED, BLACK;
	}
	
	class RBNode {
		int value;
		NodeColor color;
		RBNode parent;
		RBNode left;
		RBNode right;
		public RBNode(int value) {
			this.value = value;
			this.color = NodeColor.RED;
			if (root == null) {
				this.color = NodeColor.BLACK;
				root = this;
			}
		}
		public RBNode(int value, RBNode parent) {
			this(value);
			this.parent = parent;
		}
	}
	
	private RBNode insert(RBNode to, int value) {
		if (to == null) return new RBNode(value);
		
		if (value < to.value) {
			to.left = insert(to, value);
			to.left.parent = to;
		} else if (value > to.value) {
			to.right.parent = to;
			to.right = insert(to, value);
		}
		
		return to;
	}
	
	public void addNode(int value) {
		RBNode insertion = insert(root, value);
		
		if (insertion.parent.color != NodeColor.BLACK && 
			insertion.value != root.value) {
			RBNode grandparent = insertion.parent.parent;
			RBNode uncle = null;
			
			// find uncle
			if (grandparent != null) {
				if (grandparent.left != null) {
					if (grandparent.left.value == insertion.parent.value) {
						uncle = grandparent.right;
					} else {
						uncle = grandparent.left;
					}
				} else if (grandparent.right != null) {
					if (grandparent.right.value == insertion.parent.value) {
						uncle = grandparent.left;
					} else {
						uncle = grandparent.right;
					}
				}
			}
			
			if (uncle != null) {
				if (uncle.color == NodeColor.RED) {
					uncle.color = NodeColor.BLACK;
					insertion.parent.color = NodeColor.BLACK;
					grandparent.color = NodeColor.RED;
				}
			}
			
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
