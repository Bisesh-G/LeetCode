class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l=word1.length();
        int l2=word2.length();
        int min;
        min=Math.min(l,l2);
         String s="";
        for(int i=0;i<min;i++)
        {
            s=s+(word1.charAt(i))+(word2.charAt(i));
        }
        if (l > min) {
            s=s+(word1.substring(min));
        }
        else {
            s=s+(word2.substring(min));
        }
        return s;
    }
}