public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String newStr = "";
		for(int i = 0; i < str.length(); i ++){
			char chStr = str.charAt(i);
			if((chStr >= 'a' && chStr <= 'z') || chStr == ' ' || (chStr >= '0' && chStr <= '9')){
				newStr += chStr;
			} else if (chStr >= 'A' && chStr <= 'Z') {
				newStr += (char)(chStr + 32);
			}	
		}
		return newStr;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    //In the contains(String, String) method: Using break may simplify your code
    public static boolean contains(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length(); 
        if(len1 < len2){       //str2 is shorter than str1
            return false;
        }
        if(len2 == 0){
            return true;
        }


        char firstLetter2 = str2.charAt(0);
        for(int i = 0; i < (len1 - len2 + 1); i ++){
            if(str1.charAt(i) == firstLetter2){
                int index = i;
                boolean cheak = true;
                for(int j = 0; j < len2; j ++){    //cheaking all the letters 
                    if (str2.charAt(j) != str1.charAt(index)){
                        cheak = false;
                        break;
                    }
                    index ++;
                }
                if (cheak){
                    return true;
                }
            }
        }

        return false;      
    }
}
