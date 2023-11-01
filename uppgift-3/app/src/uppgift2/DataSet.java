package uppgift2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Generates an array of registration jumbers, ex. ABC123.
public class DataSet {
  Set<String> hashSet = new HashSet<String>();

  
  public String[] generateRegistrationNumbers(int sz) {
    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb = new StringBuilder();
    Random random = new Random();

    while (hashSet.size() != sz) {
      sb.setLength(0);

      int ix1 = random.nextInt(alpha.length());
      int ix2 = random.nextInt(alpha.length());
      int ix3 = random.nextInt(alpha.length());

      char c1 = alpha.charAt(ix1);
      char c2 = alpha.charAt(ix2);
      char c3 = alpha.charAt(ix3);
      int rndNr = random.nextInt(1000 - 100) + 100;
      
      sb.append("" + c1 + c2 + c3 + rndNr);
      hashSet.add(sb.toString());
    }

    // Convert hashset to array
    return hashSet.toArray(new String[hashSet.size()]);
  }
}
