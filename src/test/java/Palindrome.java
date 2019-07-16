public class Palindrome {
    public static void main(String[] args) {
        String s = "Civic";

//        boolean b = true;
//
//        for(int i = 0; i < s.length()/2; i++){
//            if(s.charAt(i) != s.charAt(s.length()-1-i)){
//                b = false;
//            }
//        }
//
//        if(b == true){
//            System.out.println(s + " is palindrome");
//        }
//        else{
//            System.out.println(s+ " is not palindrome");
//        }
        StringBuilder sb = new StringBuilder(s);

        sb.reverse();

        String reversed = sb.toString();

        if(s.equalsIgnoreCase(reversed)){
            System.out.println(s+ " is palindrome");
        }
        else{
            System.out.println(s+ " is not palindrome");
        }
    }
}
