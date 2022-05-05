package com.company.Tree.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    AVLNode root;

    // Constructor
    public AVLTree() {
        root = null;
        System.out.print("AVL Tree : Created Successfully");
    }

    // Pre-Order Traversal : AVL Tree
    public void preOrderTraversal(AVLNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " - ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // In-Order Traversal : AVL Tree
    public void inOrderTraversal(AVLNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value + " - ");
        inOrderTraversal(node.right);
    }

    // Post-Order Traversal : AVL Tree
    public void postOrderTraversal(AVLNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " - ");
    }

    // Level-Order Traversal : AVL Tree
    public void levelOrderTraversal(AVLNode node) {
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AVLNode presentNode = queue.remove();
            System.out.print(presentNode.value + " - ");

            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Search Node : AVL Tree
    public AVLNode searchNode(AVLNode node, int value) {
        if (node == null) {
            System.out.println(value + " : Not Found in AVL Tree");
            return null;
        } else if (value == node.value) {
            System.out.println(value + " : Found in AVL Tree");
            return node;
        } else if (value < node.value) {
            return searchNode(node.left, value);
        } else {
            return searchNode(node.right, value);
        }
    }

    // Insert Node : AVL Tree
    private AVLNode insertNode(AVLNode node, int nodeValue) {
        if (node == null) {
            AVLNode newNode = new AVLNode();
            newNode.value = nodeValue;
            newNode.height = 1;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }

        assert node != null;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalanceDifference(node);

        // For Left-Left Condition
        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }
        // For Left-Right Condition
        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // For Right-Right Condition
        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }
        // For Right-Left Condition
        if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    // Delete Node : AVL Tree
    private AVLNode deleteNode(AVLNode node, int nodeValue) {
        if (node == null) {
            System.out.println(nodeValue + " : Not found in AVL Tree");
            return null;
        }

        if (nodeValue < node.value) {
            node.left = deleteNode(node.left, nodeValue);
        } else if (nodeValue > node.value) {
            node.right = deleteNode(node.right, nodeValue);
        } else {
            if (node.left != null && node.right != null) {
                AVLNode minNodeForRight = minimumNode(node.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }

        int balance = getBalanceDifference(node);

        // For Left-Left Condition
        if (balance > 1) {
            if (node != null && getBalanceDifference(node.left) >= 0) {
                return rotateRight(node);
            }
        }
        // For Left-Right Condition
        if (node != null && balance > 1 && getBalanceDifference(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // For Right-Right Condition
        if (node != null && balance < -1 && getBalanceDifference(node.right) <= 0) {
            return rotateLeft(node);
        }
        // For Right-Left Condition
        if (node != null && balance < -1 && getBalanceDifference(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    // Delete AVL Tree : AVL Tree
    public void deleteTree() {
        root = null;
        System.out.println("AVL Tree deleted successfully");
    }

    // UTILITY METHODS : AVL Tree
    // FOR INSERTION
    // Calculate Height : AVL Tree
    public int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Rotate Left (For Right-Right) : AVL Tree
    private AVLNode rotateLeft (AVLNode disbalancedNode) {
        AVLNode newRoot = disbalancedNode.right;
        disbalancedNode.left = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // Rotate Right (For Left-Left) : AVL Tree
    public AVLNode rotateRight ( AVLNode disbalancedNode) {
        AVLNode newRoot = disbalancedNode.left;
        disbalancedNode.right = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // Get Balance Difference : AVL Tree
    public int getBalanceDifference(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // FOR DELETION
    // Minimum Node Value : AVL Tree
    public AVLNode minimumNode(AVLNode root) {
        if (root.left == null) {
            return root;
        }
        return minimumNode(root.left);
    }
}
