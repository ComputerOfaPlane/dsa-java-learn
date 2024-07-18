class Reverse {
    static boolean pallindrome(String s){ // checks entire string
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i+=1;
            j-=1;
        }
        return true;
    }
    static boolean pallindrome(String s, int i){ // checks upto a particular index
        if(i>=s.length()/2){
            return true;
        }
        if(s.charAt(i)!=s.charAt(s.length()-1-i)){
            return false;
        }
        return pallindrome(s,i+1);
    }
    static boolean pallindrome(String s, int i, int j){ // checks upto a particular index
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        else if(i>=j){
            return true;
        }
        return pallindrome(s,i+1,j-1);
    }
    static boolean pallindrom(String s, int i){ // checks upto rest 
        if(s.charAt(i)!=s.charAt(s.length()-1)){
            return false;
        }
        else if(s.length()<=1){
            return true;
        }
        return pallindrome(s.substring(i,s.length()-2),i+1);
    }
    public static void main(String[] args) {
        String a="AniketMADAM";
        String b="MADAM";
        String c="aniketmadamaniket";
        System.out.println(pallindrome(a,6,a.length()-1));
        System.out.println(pallindrome(b));
        System.out.println(pallindrome(c,6));
        System.out.println(pallindrom(c,6));
        System.out.println(pallindrom(a,6));
    }
}