/*
��Ŀ��
˼·��
������ɢ�� Spread From Center
������ĳ��Ϊ����������ɢ�ж��Ƿ��ǻ��ģ�����Сһ�㲻�ǻ���ֹͣ��ɢʱ����¼��ǰ�����ַ�����maxStr�Ƚϳ��Ⱦ����Ƿ���£��ٸ������ĵ����¶�����ɢ�����ѭ���������ַ��������ĵ㣬�ڲ�ѭ��������ĵ���������ɢ�����ⶨ��offset���Ӷ�ʵ����ɢ��
ע�⣺
1.���ĶԳ��������������������ĸ��ĳ����ĸΪ���ĶԳƣ���ż����ĸ��������ĸΪ�м�Գƣ��������ֱ���������������
2.����ָ������ѭ��ʱ�ѷֱ���м�1�ͼ�1������ȡ��ǰ���ַ���ʱ����ָ��Ӧ�ֱ��1�ͼ�1��������.substring(left+1, right)��
*/

public class Solution {
    String longest = "";
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }    
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, 0);
            helper(s, i, 1);            
        }
        return longest;
    }
    
    private void helper(String s, int index, int offset) {
        int left = index;
        int right = index + offset;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > longest.length()) {
            longest = cur;
        }
    }
}