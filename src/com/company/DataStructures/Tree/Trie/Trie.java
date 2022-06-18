package com.company.DataStructures.Tree.Trie;

public class Trie {
    private final TrieNode root;

    // Creation: Trie
    public Trie() {
        root = new TrieNode();
        System.out.println("Trie: Created Successfully");
    }

    // Insertion: Trie
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println(word + " : Successfully Inserted");
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                System.out.println(word + " : Does not exist in Trie");
                return false;
            }
            current = node;
        }
        if (current.endOfString) {
            System.out.println(word + " : Exists in Trie");
            return true;
        } else {
            System.out.println(word + " : Does not exist in Trie. But it's a prefix of another string");
        }
        return current.endOfString;
    }

    // Delete Node: Trie
    public void delete(String word) {
        if (search(word)) {
            deleteNode(root, word, 0);
        }
    }
    // Delete Node Helper
    public boolean deleteNode(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = root;
        boolean canDeleteTheNode;

        // 1st Case -> Some other word prefix is same as of given word prefix
        if (currentNode.children.size() > 1) {
            deleteNode(currentNode, word, index + 1);
            return false;
        }
        //2nd Case -> We are at last character of given word but given word is prefix of other word
        if (index == word.length() - 1) {
            if (currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        // 3rd Case -> Some other word is a prefix of given word
        if (currentNode.endOfString) {
            deleteNode(currentNode, word, index + 1);
            return false;
        }
        // 4th Case -> No other node is dependent on given word
        canDeleteTheNode = deleteNode(currentNode, word, index + 1);
        if (canDeleteTheNode) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }


}
