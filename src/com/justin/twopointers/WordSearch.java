package com.justin.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  String word = null;
  public TrieNode() {}
}

public class WordSearch {
  static char[][] board = null;
  static ArrayList<String> result = new ArrayList<String>();

  public static List<String> findWords(char[][] grid, String[] words) {
    // Step 1: Construct the Trie base on the target words.
    TrieNode root = new TrieNode();
    for (String word: words) {
      TrieNode node = root;

      for (Character letter: word.toCharArray()) {
        if (node.children.containsKey(letter)) {
          node = node.children.get(letter);
        } else {
          TrieNode newNode = new TrieNode();
          node.children.put(letter, newNode);
          node = newNode;
        }
      }
      node.word = word;
    }

    board = grid;

    // Step 2: Backgracking starting for each cell in the board.
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (root.children.containsKey(board[row][col])) {
          backtracking(row, col, root);
        }
      }
    }

    return result;
  }

  private static void backtracking(int row, int col, TrieNode parent) {
    Character letter = board[row][col];
    TrieNode currNode = parent.children.get(letter);

    // Check if there any match.
    if (currNode.word != null) {
      result.add(currNode.word);
      currNode.word = null;
    }

    // Mark down the current letter before start exploration.
    board[row][col] = '*';

    // Explore neighbour cells in: up, right, down and left.
    int[] rowOffset = {-1, 0, 1, 0};
    int[] colOffset = {0, 1, 0, -1};

    for (int i = 0; i < 4; ++i) {
      int newRow = row + rowOffset[i];
      int newCol = col + colOffset[i];
      if (newRow < 0 || newRow >= board.length || newCol < 0
          || newCol >= board[0].length) {
        continue;
      }
      if (currNode.children.containsKey(board[newRow][newCol])) {
        backtracking(newRow, newCol, currNode);
      }
    }

    // Completed, restore the original letter in the board.
    board[row][col] = letter;

    // Optimization - incrementally remove the leaf nodes.
    if (currNode.children.isEmpty()) {
      parent.children.remove(letter);
    }
  }

  public static void main(String[] args) {
    char[][] grid = new char[][] {
      { 'o', 'a', 'a', 'n' },
      { 'e', 't', 'a', 'e' },
      { 'i', 'h', 'k', 'r' },
      { 'i', 'f', 'l', 'v' },
    };
    String[] words = new String[] { "oath","pea","eat","rain" };
    List<String> results = findWords(grid, words);
    for (String item: results) {
      System.out.println(item);
    }
  }
}
