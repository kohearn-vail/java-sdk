package com.vailsys.freeclimb.percl;

public class Reject extends PerCLCommand {
    private String reason;

    public Reject(String reason) {
        this.setReason(reason);
    }

    public Reject() {}

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
