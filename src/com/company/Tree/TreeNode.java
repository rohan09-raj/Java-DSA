package com.company.Tree;

import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    // Constructor : Tree
    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    // Add Child Node : Tree
    public void addChild(TreeNode node) {
        this.children.add(node);
    }

    // Display Tree
    public StringBuilder displayTree(int level) {
        StringBuilder tree;
        tree = new StringBuilder("  ".repeat(level) + data + "\n");
        for (TreeNode node: this.children) {
            tree.append(node.displayTree(level + 1));
        }
        return tree;
    }
}
