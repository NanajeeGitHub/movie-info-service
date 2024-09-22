package com.microservices.movieinfoservice.models;

public class LoanResponse {
    private long loanId;
    private String message;

    public LoanResponse(long loanId, String message) {
        this.loanId = loanId;
        this.message = message;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
