package com.lizz.fundation.pattern.chainOfResponsibility;

/**
 * 经理审批
 */
public class ManagerApproval extends Approval {

    public  ManagerApproval(){
        //经理只能审批2天以内的
        this.max_days = 2;
    }
    @Override
    protected void agree() {
        System.out.println("manager agree");
    }
}
