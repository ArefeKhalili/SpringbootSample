package com.example.Spring_PrintRequest.printrequest;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class PrintRequestPrimarykey implements Serializable {

    private String ipAddress;
    private String branchCode;

    public PrintRequestPrimarykey(){
    }
    public PrintRequestPrimarykey(String ipAddress, String branchCode) {
        this.ipAddress = ipAddress;
        this.branchCode = branchCode;
    }
}
