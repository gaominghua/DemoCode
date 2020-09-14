package com.tjpu.Algorithm_Code.LeetCode;

class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] newStr=s.replaceAll(" ","").toLowerCase().toCharArray();
        int left=0;
        int right=newStr.length-1;
        while(left<right){
            if (Character.isLetterOrDigit(newStr[left])&&Character.isLetterOrDigit(newStr[right])){
                if(newStr[left]!=newStr[right]){
                    return false;
                }
            }else if(Character.isLetterOrDigit(newStr[left])){
                right--;
            }else {
                left++;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome =new IsPalindrome();
        String s ="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome.isPalindrome(s));
    }
}