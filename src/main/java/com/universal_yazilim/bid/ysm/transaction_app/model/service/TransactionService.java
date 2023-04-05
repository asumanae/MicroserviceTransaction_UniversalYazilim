package com.universal_yazilim.bid.ysm.transaction_app.model.service;

import com.universal_yazilim.bid.ysm.transaction_app.model.entity.Transaction;
import com.universal_yazilim.bid.ysm.transaction_app.utility.ExceptionMessageType;
import com.universal_yazilim.bid.ysm.transaction_app.utility.Util;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService extends AbstractTransactionService {
    @Override
    public Transaction findByID(Integer id) {
        try
        {
            return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
        }
        catch (RuntimeException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction save(Transaction entity) {
        try
        {
            entity.setTransactionTime(new Date());
            return transactionRepository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void deleteByID(Integer id) {
        try
        {
            transactionRepository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
        }
    }

    @Override
    public List<Transaction> findAllByUserID(Integer userId) {
        try
        {
            return transactionRepository.findAllByUserID(userId).orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
        }
        catch (RuntimeException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }
}
