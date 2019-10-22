package com.vailsys.freeclimb.webhooks.percl;

import com.google.gson.annotations.SerializedName;

public enum MachineType {
    @SerializedName("answeringMachine")
    ANSWERING,

    @SerializedName("faxMachine")
    FAX
}
