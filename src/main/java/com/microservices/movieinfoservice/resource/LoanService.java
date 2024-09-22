package com.microservices.movieinfoservice.resource;

import com.microservices.movieinfoservice.models.Loan;
import com.microservices.movieinfoservice.models.LoanResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanService {

    @PostMapping("/create")
    public ResponseEntity<LoanResponse> createLoan(@RequestBody  Loan loan){
        System.out.println("Client Name:"+loan.getClientName());
        LoanResponse loanResponse=new LoanResponse(loan.getLoanId(),"Loan Created Successfully");
        return new ResponseEntity<>(loanResponse, HttpStatus.CREATED);
    }

    @GetMapping("/review/{loanId}")
    public ResponseEntity<LoanResponse> reviewLoanStatus(@PathVariable("loanId") Long loanId){
        System.out.println("loan approved successfully:"+loanId);

        // Using ternary operator to simplify the loan response creation
        LoanResponse loanResponse = new LoanResponse(loanId,
                loanId.equals(123L) ? "Loan approved Successfully" : "Loan rejected");

        return new ResponseEntity<>(loanResponse, HttpStatus.OK);
    }
}
