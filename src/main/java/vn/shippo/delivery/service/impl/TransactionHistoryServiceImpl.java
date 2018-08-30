package vn.shippo.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.shippo.delivery.model.TransactionHistory;
import vn.shippo.delivery.repository.TransactionHistoryRepository;
import vn.shippo.delivery.service.TransactionHistoryService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    public TransactionHistoryServiceImpl(TransactionHistoryRepository transactionHistoriesRepository){
        this.transactionHistoryRepository = transactionHistoriesRepository;
    }
    @Override
    public List<TransactionHistory> findAll() {
        return (List<TransactionHistory>) transactionHistoryRepository.findAll();
    }

    @Override
    public List<TransactionHistory> findByBarcode(String barcode) {
        return transactionHistoryRepository.findByBarcode(barcode);
    }

    @Override
    public List<TransactionHistory> findByAllCreatedAtBetween(Timestamp createAt) {
        return transactionHistoryRepository.findAllByCreatedAtBetween(createAt);
    }

    @Override
    public List<TransactionHistory> findAllByTransType(String transType) {
        return transactionHistoryRepository.findAllByTransType(transType);
    }

    @Override
    public List<TransactionHistory> findByBarcodeAndTransType(String barcode, String transType  ) {
        return transactionHistoryRepository.findByBarcodeAndTransType(barcode, transType);
    }
}
