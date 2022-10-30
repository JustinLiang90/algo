package com.justin.twopointers;

import java.util.ArrayList;
import java.util.TreeMap;

public class CardTypeSolution {
  public static class BinRange {
    private String start;
    private String end;
    private String type;

    public BinRange(String start, String end, String type) {
      this.start = start;
      this.end = end;
      this.type = type;
    }
  }

  public interface Cache {
    String getCardType(String cardNumber);
  }

  public static class InMemoryCache implements Cache {
    private TreeMap<String, BinRange> inMemoryCache;
    private int binLength = Integer.MAX_VALUE;

    public InMemoryCache() {
      if (inMemoryCache == null) {
        inMemoryCache = new TreeMap<String, BinRange>((a, b) -> a.compareTo(b));
      }
    }

    public void buildInMemoryCache(ArrayList<BinRange> binRanges) {
      for (BinRange binRange : binRanges) {
        binLength = Math.min(binLength, binRange.start.length());
        inMemoryCache.put(binRange.start, binRange);
      }
    }

    @Override
    public String getCardType(String cardNumber) {
      String cardBin = cardNumber.substring(0, binLength);
      String floorKey = inMemoryCache.floorKey(cardBin);
      String ceilKey = inMemoryCache.ceilingKey(cardBin);

      if (floorKey != null) {
        BinRange currentBinRange = inMemoryCache.get(floorKey);
        if (isCardInRange(cardBin, currentBinRange)) {
          return currentBinRange.type;
        }
      }
      if (ceilKey != null) {
        BinRange currentBinRange = inMemoryCache.get(ceilKey);
        if (isCardInRange(cardBin, currentBinRange)) {
          return currentBinRange.type;
        }
      }
      return null;
    }

    private boolean isCardInRange(String cardBin, BinRange binRange) {
      return cardBin.compareTo(binRange.start) >= 0 && cardBin.compareTo(binRange.end) <=0;
    }
  }

  public static void main(String[] args) {
    BinRange visaCredit = new BinRange("4444444411", "4444444444", "Visa credit");
    BinRange visaDebit = new BinRange("4500000055", "4999999900", "Visa debit");
    BinRange masterCredit = new BinRange("4999999999", "5555000000", "Master credit");
    BinRange amex = new BinRange("6666444411", "7777000000", "Amex");

    ArrayList<BinRange> bins = new ArrayList<>();
    bins.add(visaCredit);
    bins.add(visaDebit);
    bins.add(masterCredit);
    bins.add(amex);

    InMemoryCache cache = new InMemoryCache();
    cache.buildInMemoryCache(bins);
    String result = cache.getCardType("4733610979012139");
    System.out.println(result);
  }
}
