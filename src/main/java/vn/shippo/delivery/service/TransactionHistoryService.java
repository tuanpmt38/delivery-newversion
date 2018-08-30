package vn.shippo.delivery.service;

import vn.shippo.delivery.model.TransactionHistory;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionHistoryService {

    List<TransactionHistory> findAll();

    List<TransactionHistory> findByBarcode(String barcode);

    List<TransactionHistory> findByAllCreatedAtBetween(Timestamp createAt);

    List<TransactionHistory> findAllByTransType(String transType);

    List<TransactionHistory> findByBarcodeAndTransType(String barcode, String transType);
}
