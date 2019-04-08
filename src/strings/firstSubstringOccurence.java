package strings;

public class firstSubstringOccurence {


  // could place substrnig at every character to see if they match
  // O(n^2)
  // O(n) to check every character
  // O(n) to match at each character
  public int findFirstIndex(String text, String substringToMatch){

    for(int i = 0; i < text.length() - substringToMatch.length() + 1; i++){
      if (text.substring(i, i + substringToMatch.length()).equals(substringToMatch)) {
        return i;
      }
    }

    return -1;
  }

  public int robinKarp(String text, String substringToMatch){
    int matchHash = 0;
    int rollingHash = 0;

    // set hashes
    for(int i = 0; i < substringToMatch.length(); i++){
      matchHash += substringToMatch.charAt(i);
      rollingHash += text.charAt(i);
    }


    //matchHash %= 31;
    //rollingHash %= 31;

    // run through string to find matching hashes,
    // if matching hash found, check char by char
    int j = 0;
    int i = 0;
    for(i = substringToMatch.length(); i < text.length(); i++){
      // check if hash of previous substring equals matchHash
      if(matchHash == rollingHash){
        for(j = 0; j < substringToMatch.length(); j++){
          if(text.charAt(i+j-1) != substringToMatch.charAt(j))
            break;
        }
        if (j == substringToMatch.length()) return i-1;
        System.out.println();
      }

      // update rolling hash
      rollingHash -= text.charAt(i- substringToMatch.length());
      rollingHash += text.charAt(i);
      //rollingHash %= 31;
    }

    if (matchHash == rollingHash){
      for(j = 0; j < substringToMatch.length(); j++){
        if (text.charAt(i-substringToMatch.length() + j) != substringToMatch.charAt(j)) return -1;
      }
      return i - substringToMatch.length();
    }

    return -1;
  }

}
