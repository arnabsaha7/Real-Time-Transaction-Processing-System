package com.cloudthat.bankingApp.service;

import com.cloudthat.bankingApp.entity.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FraudDetectionService {

    // Threshold amount to flag a transaction as fraudulent
    private static final BigDecimal FRAUD_THRESHOLD = new BigDecimal("10000");

    public boolean isFraudulent(Transaction transaction) {
        // Simple logic: Flag transactions above the threshold amount as fraudulent
        return transaction.getAmount().compareTo(FRAUD_THRESHOLD) > 0;
    }
}
