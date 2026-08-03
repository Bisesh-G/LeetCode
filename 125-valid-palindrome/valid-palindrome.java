class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1 ||s.length()==0)
            return true;

        String t = (s.replaceAll("[^a-zA-Z0-9]", "")).toLowerCase(); 

        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)!=t.charAt(t.length()-1-i))
                return false;
        }
        return true;
        
    }
}