package com.cloudthat.bankingApp.service;

import com.cloudthat.bankingApp.entity.Transaction;
import com.cloudthat.bankingApp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private FraudDetectionService fraudDetectionService;

    public Transaction processTransaction(Transaction transaction) {
        // Validate the transaction details
        validateTransaction(transaction);

        // Check for potential fraud
        boolean isFraudulent = fraudDetectionService.isFraudulent(transaction);
        if (isFraudulent) {
            transaction.setStatus("FAILED");
            throw new RuntimeException("Transaction flagged as fraudulent");
        }

        // Business logic to process the transaction
        transaction.setTransactionTime(LocalDateTime.now());
        transaction.setStatus("SUCCESS");

        // Save the transaction in the database
        return transactionRepository.save(transaction);
    }

    // Method to validate transaction details
    private void validateTransaction(Transaction transaction) {
        if (transaction.getAccountNumber() == null || transaction.getAccountNumber().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }

        if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
        }
    }
}
