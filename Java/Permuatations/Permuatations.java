package permuatations;

/**
 *
 * @author Neil
 */
public class Permuatations {

    public static String s; //string we are looking for permuations of
    public static String b; //string we are looking for permutations within

    /*this function takes a string of a length equal to the string we are comparing
    and runs a simple check on each character individually seeing if it can correctly
    and uniquely map each to the sequence pulled from string b. if successful, a print
    statement is executed declaring a permuation has been found*/
    public static void assessPerm(String test, int index) {
        boolean[] matched = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < test.length(); j++) {
                if (s.charAt(i) == test.charAt(j) && matched[j] != true) {
                    matched[j] = true;
                    break;
                }//if
            }//for j
        }//for i

        /*for loop checking the matched characters, if any characters aren't
        matched then the function ends by returning void. if they are all matched then
        the print statement is executed detailing the found permuation*/
        for (int i = 0; i < s.length(); i++) {
            if (matched[i] == true) {
                continue;
            } else {
                return;
            }
        }//for

        System.out.println("\"" + test + "\"" + "is a permuation atindex: " + index + "-" + (s.length() + index));
    }//assessPerm

    /*this function steps through string b extracting s.length() of chars at a time
    to process them for permuation checking*/
    public static void findPerms(String s, String b) {
        for (int i = 0; i < b.length() && b.length() - i >= s.length(); i++) {
            String test = "";
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sb.append(b.charAt(i + j));
            }
            test = sb.toString();
            assessPerm(test, i);
        }

    }

    public static void main(String[] args) {
        s = "abbc";
        b = "cbabadcbbabbcbabaabccbabc";
        System.out.println("Finding permutations of:\n" + s);
        System.out.println("In:\n" + b);
        findPerms(s, b);
    }

}
