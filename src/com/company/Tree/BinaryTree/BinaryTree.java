package com.company.Tree.BinaryTree;

import java.util.Objects;

public class BinaryTree {
    String[] binaryTree;
    int lastUsedIndex;

    // Constructor : Binary Tree
    public BinaryTree(int size) {
        binaryTree = new String[size];
        this.lastUsedIndex = 0;
        System.out.println("Binary Tree created successfully of size: " + size);
    }

    // isFull : Binary Tree
    public boolean isFull() {
        return binaryTree.length-1 == lastUsedIndex;
    }

    // Insert a Node : Binary Tree
    public void insertNode(String value) {
        if (isFull()) {
            System.out.println("Binary Tree is full");
        } else {
            binaryTree[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println(value + " : Inserted Successfully");
        }
    }

    // Pre-Order Traversal : Binary Tree
    public void preOrderTraversal(int index) {
        if(index > lastUsedIndex) {
            return;
        }
        System.out.print(binaryTree[index] + " - ");
        preOrderTraversal(2 * index);
        preOrderTraversal(2 * index + 1);
    }

    // In-Order Traversal : Binary Tree
    public void inOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        inOrderTraversal(2 * index);
        System.out.print(binaryTree[index] + " - ");
        inOrderTraversal(2 * index + 1);
    }

    // Post-Order Traversal : Binary Tree
    public void postOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        postOrderTraversal(2 * index);
        postOrderTraversal(2 * index + 1);
        System.out.print(binaryTree[index] + " - ");
    }

    // Level-Order Traversal : Binary Tree
    public void levelOrderTraversal() {
        for (int i=1; i<=lastUsedIndex; i++) {
            System.out.print(binaryTree[i] + " - ");
        }
        System.out.println();
    }

    // Search Node : Binary Tree
    public int searchNode(String value) {
        for (int i=1; i<=lastUsedIndex; i++) {
            if (Objects.equals(binaryTree[i], value)) {
                System.out.println(value + " found at location : " + i);
                return i;
            }
        }
        System.out.println("Value does not exist");
        return -1;
    }

    // Delete Node : Binary Tree
    public void deleteNode(String value) {
        int location = searchNode(value);
        if (location == -1) {
            System.out.println("Value does not exist");
        } else {
            binaryTree[location] = binaryTree[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("Node Deleted successfully");
        }
    }

    // Delete Tree : Binary Tree
    public void deleteBinaryTree() {
        try {
            binaryTree = null;
            System.out.println("Binary Tree deleted successfully");
        } catch (Exception e) {
            System.out.println("Error occurred during deleting Binary : " + e);
        }
    }
}
