package com.universal_yazilim.bid.ysm.transaction_app.controller;


import com.universal_yazilim.bid.ysm.transaction_app.model.entity.Transaction;
import com.universal_yazilim.bid.ysm.transaction_app.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController {
    @Autowired
    private AbstractTransactionService transactionService;
    @GetMapping
    public ResponseEntity<List<Transaction>> getAll() {
        List<Transaction> productList1 = transactionService.getAll();
        return ResponseEntity.ok(productList1);
    }

    @PostMapping
    public ResponseEntity<Transaction> save (@RequestBody Transaction transaction) {
        transaction.setTransactionTime(new Date());
        Transaction savedProduct = transactionService.save(transaction);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable(name = "id") Integer transactionId) {
        transactionService.deleteByID(transactionId);
        return ResponseEntity.ok("Transaction deleted successfully!");
    }

    @GetMapping("user/{id}")
    public ResponseEntity<List<Transaction>> findByUserId(@PathVariable(name = "id") Integer userId) {
        List<Transaction> transactionList = transactionService.findAllByUserID(userId);
        return ResponseEntity.ok(transactionList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Transaction> findById(@PathVariable(name = "id") Integer transactionId) {
        Transaction transaction = transactionService.findByID(transactionId);
        return ResponseEntity.ok(transaction);
    }
}
