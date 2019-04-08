package strings;

import java.util.List;

public class driver {

  public static void main(String[] args){

    interconvert_strings_ints_7_1 ex_7_1 = new interconvert_strings_ints_7_1();
    int num = ex_7_1.stringToInt("541");
    System.out.println("num = " + num);
    System.out.println();

    String sNum = ex_7_1.intToString(541);
    System.out.println(sNum);

    System.out.println();
    baseConversion_7_2 ex_7_2 = new baseConversion_7_2();
    String baseRep = ex_7_2.convertBase("615", 7, 13);
    System.out.println(baseRep);
    System.out.println();


    System.out.println();
    spreadSheetEncoding_7_3 ex_7_3 = new spreadSheetEncoding_7_3();
    int valA = ex_7_3.decodeColumn("A");
    int valZZ = ex_7_3.decodeColumn("ZZ");
    System.out.println("Val of A = " + valA);
    System.out.println("Val of ZZ = " + valZZ );
    System.out.println();

    replaceAndRemove ex_7_4 = new replaceAndRemove();
    char[] replaceRes = ex_7_4.transform(new char[]{'a','c','d','b','b','c','a'},4);
    char[] replaceResV1 = ex_7_4.transformV1(new char[]{'a','c','d','b','b','c','a'},4);

    for(char Char : replaceRes) System.out.print(Char + " ");
    System.out.println();
    for(char Char : replaceResV1) System.out.print(Char + " ");
    System.out.println();

    Palindrome_ex_7_5 ex_7_5 = new Palindrome_ex_7_5();
    System.out.println();
    System.out.println("tacocat : " + ex_7_5.isPalindrome("tacocat"));
    System.out.println("A man, a plan, a canal, Panama. : " + ex_7_5.isPalindrome("A man, a plan, a canal, Panama."));
    System.out.println("Able was I, ere I saw Elba! : " + ex_7_5.isPalindrome("Able was I, ere I saw Elba!"));
    System.out.println("Ray is Ray : " + ex_7_5.isPalindrome("Ray is Ray"));
    System.out.println();

    reverseWordsInASentence ex_7_6 = new reverseWordsInASentence();
    System.out.println(ex_7_6.reverseWords("hi pal"));
    System.out.println();


    phoneMnemonics ex_7_7 = new phoneMnemonics();
    ex_7_7.driver("222");
    List<String> res = ex_7_7.phoneMnemonic("222");
    System.out.println();
    for(String nmeonic : res ) System.out.print(nmeonic + " ");
    System.out.println();
    System.out.println();

    lookAndSay_7_8 ex_7_8 = new lookAndSay_7_8();
    ex_7_8.nthSequence(5);
    System.out.println();
    System.out.println();


    roman2Decimal_7_9 ex_7_9 = new roman2Decimal_7_9();
    ex_7_9.convert2Decimal("XV");
    ex_7_9.convert2Decimal("LIX");
    ex_7_9.convert2Decimal("XVII");
    ex_7_9.convert2Decimal("IV");

    System.out.println();

    validIPAddress_7_10 ex_7_10 = new validIPAddress_7_10();
    ex_7_10.driver("19216811");

    System.out.println();
    nQueens backtrackPractice = new nQueens();
    backtrackPractice.helper(5);

    sinusString_7_11 ex_7_11 = new sinusString_7_11();
    System.out.println(ex_7_11.returnSnakeString("HELLO_WORLD!"));
    System.out.println();

    runLengthEncoding ex_7_12 = new runLengthEncoding();
    String encodedString = ex_7_12.encoding("aaabbaa");
    String decodedString = ex_7_12.decoding(encodedString);
    System.out.println("encoded String = " + encodedString);
    System.out.println("decoded String = " + decodedString);
    System.out.println();

    firstSubstringOccurence ex_7_13 = new firstSubstringOccurence();
    long startTime, endTime, duration;
    startTime = System.nanoTime();
    int index = ex_7_13.findFirstIndex("aagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaabd", "abd");
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println("first index = " + index + " took " + duration + " nanoseconds.");

    startTime = System.nanoTime();
    int robinIndex = ex_7_13.robinKarp("aagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaaaagcgagcgatatatataaaaaabd", "abd");
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println("robin index = " + robinIndex + " took " + duration + " nanoseconds.");


  }
}
