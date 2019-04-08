package strings;

import java.util.ArrayList;
import java.util.List;

public class validIPAddress_7_10 {
  // backtracking

  // goal: 4 segments use all characters
    // base case
        // segment == 4
        // buildIdx = rawIP.length() - 1
  // choice: take the next number
  // constraints :
      // between 0 and 255 inclusive
      // cannot have leading 0


  // can be computed as four decimal strings separated by a decimal
  // strings lengths 1-3
  // no leading 0's
  // values have to be between 0 and 255

  public void driver(String rawIP){
    List<String> listOfIPS = new ArrayList<>();
    int[] possibleIP = new int[4];
    findIP(0, possibleIP, rawIP, listOfIPS, 0);

    for(String ip : listOfIPS) System.out.println(ip);

  }



  private void findIP(int segment, int[] value, String rawIP, List<String> res, int buildIdx){

    if(segment == 4 && buildIdx == rawIP.length()){           // base case
      res.add(Integer.toString(value[0]) + '.' + Integer.toString(value[1]) + '.' + Integer.toString(value[2])  + '.' + Integer.toString(value[3]));
      return;
    } else if (segment == 4 || buildIdx == rawIP.length()){
      return;
    }

    // grab next number , LEN has to be <= 3 and LEN + buildIDX < rawIP.lenth() - 1
    for(int len = 1; len <= 3 && buildIdx + len <= rawIP.length(); len++){
      String snapshot = rawIP.substring(buildIdx, buildIdx + len);      // grab IP between length 1 and 3
      System.out.println("Snapshot = " + snapshot);
      int snapshotValue = Integer.parseInt(snapshot);                   // convert to int
      if(snapshotValue > 255 || len >= 2 && rawIP.charAt(buildIdx) == '0'){     // constraints; invalid values
        break;
      }
      value[segment] = snapshotValue;                                            // choose
      findIP(segment+1, value, rawIP, res, buildIdx + len);    // explore
      value[segment] = -1;                                                      // unchoose
    }




  }
}
