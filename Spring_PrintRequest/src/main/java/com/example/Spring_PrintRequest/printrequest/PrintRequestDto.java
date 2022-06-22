package com.example.Spring_PrintRequest.printrequest;

public class PrintRequestDto {

    private String cardPAN;
    private String branchCode;

    public PrintRequestDto(String cardPAN, String branchCode) {

        this.cardPAN = cardPAN;
        this.branchCode = branchCode;
    }

    public String getCardPAN() {
        return cardPAN;
    }

    public void setCardPAN(String cardPAN) {
        this.cardPAN = cardPAN;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
}
