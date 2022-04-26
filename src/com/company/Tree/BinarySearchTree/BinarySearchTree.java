package com.company.Tree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BSTNode root;

    // Constructor : BST
    public BinarySearchTree() {
        root = null;
    }

    // Insert Node : BST
    private BSTNode insertNode(BSTNode currentNode, int value) {
        if (currentNode == null) {
            BSTNode newNode = new BSTNode();
            newNode.value = value;
            System.out.println("Node : Inserted Successfully");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insertNode(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insertNode(currentNode.right, value);
            return currentNode;
        }
    }

    public void insert(int value) {
        insertNode(root, value);
    }

    // Pre-Order Traversal : BST
    public void preOrderTraversal(BSTNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " - ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // In-Order Traversal : BST
    public void inOrderTraversal(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.value + " - ");
        inOrderTraversal(node.right);
    }

    // Post-Order Traversal : BST
    public void postOrderTraversal(BSTNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " - ");
    }

    // Level-Order Traversal : BST
    public void levelOrderTraversal() {
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode presentNode = queue.remove();
            System.out.print(presentNode.value + " - ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Search Node : BST
    public BSTNode searchNode(BSTNode node, int value) {
        if (node == null) {
            System.out.print("Value : " + value + " not found in BST" );
            return null;
        } else if (value == node.value) {
            System.out.print("Value : " + value + " found in BST");
            return node;
        } else if (value < node.value) {
            return searchNode(node.left, value);
        } else {
            return searchNode(node.right, value);
        }
    }

    // Minimum Node : BST
    public static BSTNode minimumNode(BSTNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete Node : BST
    public BSTNode deleteNode(BSTNode root, int value) {
        if (root == null) {
            System.out.print("Value not found in BST");
            return null;
        }

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BSTNode minimumNodeForRight = minimumNode(root.right);
                root.value = minimumNodeForRight.value;
                root.right = deleteNode(root.right, minimumNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    // Delete : BST
    public void delete() {
        root = null;
        System.out.print("BST deleted successfully");
    }
}
