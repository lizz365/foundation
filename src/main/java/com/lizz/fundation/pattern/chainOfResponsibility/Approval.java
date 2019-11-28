package com.lizz.fundation.pattern.chainOfResponsibility;

/**
 * 责任链操作类
 * 请假审批责任链
 */
public abstract class Approval {

    protected Approval nextApproval;

    //允许审批天数
    protected int max_days;

    public void setNextApproval(Approval nextApproval) {
        this.nextApproval = nextApproval;
    }

    /**
     * 申请休假
     * @param days
     */
    public void vacation(int days){
        if(days <= max_days){
            agree();
        }else{
            if(nextApproval != null){
                nextApproval.vacation(days);
            }else{
                System.out.println("out of maxdays");
            }
        }
    }

    abstract protected void agree();
}
