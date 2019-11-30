package com.lizz.fundation.pattern.chainOfResponsibility;

import org.junit.Test;

public class Tester {
    @Test
    public void chainOfResponsibility(){
        CEOApproval ceoApproval = new CEOApproval();
        ManagerApproval managerApproval = new ManagerApproval();
        managerApproval.setNextApproval(ceoApproval);

        managerApproval.vacation(1);
        managerApproval.vacation(3);
        managerApproval.vacation(2);
        managerApproval.vacation(10);
    }
}
