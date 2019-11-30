package com.lizz.fundation.pattern.template;

import org.junit.Test;

public class Tester {
    @Test
    public void template(){
        System.out.println("Loser's life");
        Life life = new LoserLife();
        life.live();
        System.out.println("Winner's life");
        life = new WinnerLife();
        life.live();
    }
}
