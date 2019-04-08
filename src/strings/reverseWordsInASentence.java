package strings;

public class reverseWordsInASentence {

  private String reverseWord(int beginIndex, int endIndex, String sentence){
    StringBuilder sbSentence = new StringBuilder(sentence);
    while(beginIndex < endIndex){
      char tmp = sbSentence.charAt(endIndex);
      sbSentence.setCharAt(endIndex--, sbSentence.charAt(beginIndex));
      sbSentence.setCharAt(beginIndex++, tmp);
    }

    return sbSentence.toString();
  }

  public String reverseWords(String sentence){

    // reverse entire sentence
    sentence = reverseWord(0, sentence.length() - 1, sentence);
    System.out.println("sentence = " + sentence);

    // if i swap from begin ptr to end ptr; words will be reversed but backwards
    // we can do this and THEN iterate through sentence
      // 1.) find begin index of word
      // 2.) find end index of word (before space)
      // 3.) reverse from (begin,end)
      // 4.) repeat until end of string

    // hi pal => lap ih => pal hi
    int beginIdx, endIdx;
    beginIdx = sentence.length() - 1;
    endIdx = sentence.length() - 1;
    while(beginIdx >= 0) {
      while (sentence.charAt(beginIdx) != ' ' && beginIdx != 0) {
        beginIdx--;
      }
      if (beginIdx == 0) {
        sentence = reverseWord(beginIdx, endIdx, sentence);
      } else {
       sentence = reverseWord(beginIdx + 1, endIdx, sentence);
      }
      beginIdx--;
      endIdx = beginIdx;
    }

    return sentence;

  }


}
