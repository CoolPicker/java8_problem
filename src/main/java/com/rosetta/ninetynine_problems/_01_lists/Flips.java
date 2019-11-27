package com.rosetta.ninetynine_problems._01_lists;


/**
 * 典型的用例
 */
public class Flips {
    public static void main(String[] args) {
        int T = Integer.parseInt("1000000");
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int t = 0 ; t < T ; t++) {
            if (Math.random() > 0.5) {
                heads.increment();
            } else {
                tails.increment();
            }
        }
        System.out.println(heads);
        System.out.println(tails);
        int d = heads.tally() - tails.tally();
        System.out.println("delta: " + Math.abs(d));

        int[] mm = {22,33,44,55,66,11,88,99};
        StaticSEofInts ints = new StaticSEofInts(mm);
        boolean res = ints.contains(45);
        System.out.println(res);
    }
}
