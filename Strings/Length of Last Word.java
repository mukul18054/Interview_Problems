/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        String temp="";
        
        
        String B="";
        
        //delete any whtie space chars before or after the string
        B=B.trim();
        int n=A.length();
        
        String ans="";
        //check that we have got our first word yet or not
        boolean first=true;
        for(int i=n-1;i>=0;i--){ //starting from end
            //as soon as we get our first white space means we already have last word in temp var.
            if(A.charAt(i)==' '){
                if(first==false)
                break;
                if(temp.length()!=0){
                    ans=temp;
                }
                temp="";
            }
            else{
                first =false;
                temp=A.charAt(i)+temp;
            }
        }
        //if word length != 0 then assign temp to ans
        if(temp.length()!=0){
            ans=temp;
        }
        
        //return len of last word
        return ans.length();
        
    }
}
