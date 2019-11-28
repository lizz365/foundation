package com.lizz.fundation.pattern.chainOfResponsibility;

/**
 * 经理审批
 */
public class CEOApproval extends Approval {
    public CEOApproval(){
        this.max_days = 7;
    }
    @Override
    protected void agree() {
        System.out.println("ceo agree");
    }
}
