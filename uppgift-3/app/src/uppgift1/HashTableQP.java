package uppgift1;

import java.util.Arrays;

public class HashTableQP {
  private int sz;
  private String[] table;
  int collisions;
  int hv;

  public HashTableQP(int sz) {
    collisions = 0;
    this.sz = sz;
    this.table = new String[sz];
  }

  public int insert(String key) {
    try {
    int hv;
    int i = 1;

    // If we want to deny insert if table is half full.
    // Comment out to continue to try buckets.
    if (sz / 2 == getLength()) {
      return -1;
    }

    hv = gethash(key) % sz;
    
    if (table[hv] == null) {
      table[hv] = key;
      return 0;
    } else {
      while (table[hv] != null) {
        // Quadratic insert
        hv = (hv + i * i) % sz;
        
        i++;
        collisions++;
      }
      table[hv] = key;
    }
    
    return i - 1;
  } catch (Exception e) {
    // return -1;
    throw new Error("Full");
    }
  }

  public boolean find(String key) {
    try {
    int hv;
    hv = gethash(key) % sz;

    int i = 1;
    while(table[hv] != null) {
      // fix: equals instead of "=="
    if (table[hv].equals(key)) {
        return true;
    }
      // Quadratic find
      hv = (hv + i * i) % sz;
      
      i++;
    }

    return false;
    } catch (Exception e) {
      return false;
    }
  }

  public int gethash(String key) {
    int primeBase = 17;
    int hv = 31 * primeBase + key.hashCode();

    // Avoiding negative hash values.
    if (hv < 0) {
      hv = Math.abs(hv);
    }
    
    return hv;
  }

  public int getLength() {
    int cnt = 0;

    for (int i = 0; i < table.length; i++) {
      if (table[i] != null) {
        cnt++;
      }
    }

    return cnt;
  }

  public String[] table () {
    // Fix: return copy of array
    return Arrays.copyOf(table, table.length);
  }

  public int getCollisions() {
      return collisions;
  }
}
