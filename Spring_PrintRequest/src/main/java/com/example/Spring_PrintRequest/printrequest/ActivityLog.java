package com.example.Spring_PrintRequest.printrequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_ActivityLog")
public class ActivityLog {
    public ActivityLog() {
    }

    ;

    public ActivityLog(String cardPAN, String operationName, String personnelCode, String applicationType, Date operationDate) {
        this.cardPAN = cardPAN;
        this.personnelCode = personnelCode;
        this.operationName = operationName;
        this.applicationType = applicationType;
        this.operationDate = operationDate;
    }

    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView({Views.Public.class, Views.Create.class})
    @Column(name = "c_cardPAN")
    private String cardPAN;

    @JsonView({Views.Public.class, Views.Create.class})
    @Column(name = "c_personnelCode")
    private String personnelCode;

    @Column(name = "c_operationName")
    private String operationName;

    @Column(name = "c_applicationType")
    private String applicationType;

    @JsonView({Views.Public.class, Views.Create.class})
    @Column(name = "c_operationdate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date operationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public Date getOperationdate() {
        return operationDate;
    }

    public void setOperationdate(Date operationdate) {
        this.operationDate = operationdate;
    }
}
