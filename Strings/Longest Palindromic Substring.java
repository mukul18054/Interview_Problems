/*
Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"
*/

public class Solution {
    public int maxPaliFromHere(String A, int s){
        int i=s-1,j=s+1;
        int n=A.length();
        
        //count 1 for odd len palindrome string with s as the center character
        //count 2 for even len palindrome string with s as the left char of 2 center characters
        int count=1,count2=0;
        while(i>=0 && j<n){
            if(A.charAt(i)==A.charAt(j)){
                count+=2;
            }
            else{ 
                break;
            }
            i--;
            j++;
        }
        
        //i = s as index s is one of the center char in the even length palindromic string
        i=s;
        j=s+1;
        while(i>=0 && j<n){
            if(A.charAt(i)==A.charAt(j)){
                count2+=2;
            }
            else{
                break;
            }
            i--;
            j++;
        }
        // return max of count
        return Math.max(count,count2);
    }
    public String longestPalindrome(String A) {
        int n=A.length();
        int ans=0;
        String anss="";
        
        //for each index in String
        for(int i=0;i<n;i++){
            //get the max length of palindromic string with ith index as the mid index
            int temp=maxPaliFromHere(A, i);
            
            //if it's > than ans then update ans
            if(temp>ans){
                ans=temp;
                
                //update string ans as well
                if(ans%2 == 0){
                    //if even len then substring from i-(temp-1)/2 to i+temp/2+1
                    anss=A.substring(i-(temp-1)/2,i+temp/2+1);
                }
                else{
                    //else substring from i-(temp)/2 to i+temp/2+1
                    anss=A.substring(i-temp/2,i+temp/2+1);                    
                }

            }
            
        }
    return anss;
    }

}
