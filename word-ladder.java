/*
题目：
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,
Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

思路：
开始需要定义三个Set：beginSet用来存放beginWord，endSet存放endWord，visited存放转化过程中产生的单词，另外定义一个变量count并初始化为1。
转化过程中另需定义一个Set：tmp用来存放当前转化后的单词candidate，并在每次循环结束更新beginSet为tmp。
转化过程是把beginSet的每一个单词word拿出来，再把word的每一位换成'a'到'z'的其他字母，看转化后的单词candidate是否在endSet里出现：若出现则直接返回count加1；反之，若candidate在visited没出现过，在WordList出现过，则把当前candidate加到tmp，再把beginSet更新为tmp，因为距离endWord又近了一步，因此count加1。
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> dictList = new HashSet<>(wordList);
        
        int count = 1;
        Set<String> visitedSet = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // if (beginSet.size() > endSet.size()) {
            //     Set<String> t = beginSet;
            //     beginSet = endSet;
            //     endSet = t;
            // }
            
            Set<String> tmpSet = new HashSet<>();
            for (String word : beginSet) {
                char[] word2array = word.toCharArray();
                for (int i = 0; i < word2array.length; i++) {
                    char old = word2array[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word2array[i] = c;
                        String candidate = String.valueOf(word2array);
                        
                        if (endSet.contains(candidate)) {
                            return count + 1;
                        } 
                        if (!visitedSet.contains(candidate) && dictList.contains(candidate)) {
                            visitedSet.add(candidate);
                            tmpSet.add(candidate);
                        }
                        word2array[i] = old;
                    }
                }
            }
            beginSet = tmpSet;
            count++;
        }
        return 0;
    }
}