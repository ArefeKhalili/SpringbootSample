package com.example.Spring_PrintRequest.printrequest;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Entity
@Table(name = "T_PrintRequest")
public class PrintRequest {
        public PrintRequest(){};

    public PrintRequest(PrintRequestPrimarykey id, String cardPAN, String branchCode,String personnelCode, String ipAddress) {
        this.id = id;
        this.cardPAN = cardPAN;
        this.personnelCode = personnelCode;
        this.ipAddress = ipAddress;
        this.branchCode=branchCode;
    }

    @EmbeddedId
    private PrintRequestPrimarykey id;

    @JsonView({Views.Public.class,Views.Create.class})
    @Column(name = "c_cardPAN")
    private String cardPAN;

    @JsonView({Views.Public.class,Views.Create.class})
    @Column(name = "c_personnelCode")
    @NotNull(message = "personnelCode must not be null")
    private String personnelCode;

    @JsonView({Views.Public.class,Views.Create.class})
    @Column(name = "c_branchCode")
    @NotNull(message = "branchCode must not be null")
    private String branchCode;

    @JsonView({Views.Public.class,Views.Create.class})
    @Column(name = "c_ipAddress")
    private String ipAddress;

    public String getCardPAN() {
        return cardPAN;
    }

    public void setCardPAN(String cardPAN) {
        this.cardPAN = cardPAN;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public PrintRequestPrimarykey getId() {
        return id;
    }

    public void setId(PrintRequestPrimarykey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PrintRequest{" +
                "id=" + id +
                ", cardPAN='" + cardPAN + '\'' +
                ", personnelCode='" + personnelCode + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
