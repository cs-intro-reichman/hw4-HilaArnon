public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",                         //this
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",                    //this
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",    //this
            "The team showed great Synergy in the last project",          //this
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",   //this
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for(int j = 0; j < keywords.length; j++){           //key words to lower cases
            keywords[j] = lowerCase(keywords[j]);
        }

        for(int i = 0; i < sentences.length; i ++){
            String correntSentence = lowerCase(sentences[i]);
            for(int j = 0; j < keywords.length; j++){
                if (contains(correntSentence, keywords[j])){
                    System.out.println(sentences[i]);
                    break;
                }
            }
        }
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

        char firstLetter2 = str2.charAt(0);
        for(int i = 0; i < (len1 - len2 + 1); i ++){
            if(str1.charAt(i) == firstLetter2){     //same letter as first str2's letter
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
