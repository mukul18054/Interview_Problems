/*
Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.
*/

public class Solution {
    public String addBinary(String A, String B) {
        //length 
        int n1=A.length();
        int n2=B.length();
        
        //adding 0's in the start of A if lenA < lenB to make length of both strings equal
        if(n1<n2){
            int diff=n2-n1;
            for(int i=0;i<diff;i++){
                A='0'+A;
            }
        }
        
        else{
            int diff=n1-n2;
            for(int i=0;i<diff;i++){
                B='0'+B;
            }
        }
        
        //carry bit
        int c=0;
        String C="";
        int ma=Math.max(n1,n2);
        
        //for i from length of string -1 to 0
        for(int i=ma-1;i>=0;i--){
            int a=Integer.valueOf(A.charAt(i)-'0');
            int b=Integer.valueOf(B.charAt(i)-'0');
            if(a+b+c==3){
                C='1'+C;
                c=1;
            }
            else if(a+b+c==2){
                C='0'+C;
                c=1;
            }
            else{
                int tt=a+b+c;
                C=String.valueOf(tt)+C;
                c=0;
            }
            
        }
        
        //if carry is left then add it
        if(c>=1){
        
            C='1'+C;
        }
        return C;
    }
}
