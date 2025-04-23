class pallindrome{
    public static boolean check(String s) {
        // String s = "aniketekina";
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}