package vn.shippo.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.shippo.delivery.model.TransactionHistory;
import vn.shippo.delivery.repository.TransactionHistoryRepository;
import vn.shippo.delivery.service.TransactionHistoryService;

import java.util.List;

@RestController

public class TransactionHistoryController {

    private TransactionHistoryService transactionHistoryService;
    @Autowired
    private TransactionHistoryRepository transactionHistoriesRepository;

    @Autowired
    public TransactionHistoryController(TransactionHistoryService transactionHistoriesService){
        this.transactionHistoryService = transactionHistoriesService;
    }

    @RequestMapping(value = "/customer_transactions/", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionHistory>> getAllCustomerTransactions(){

        List<TransactionHistory> transactionHistories = transactionHistoryService.findAll();
        if(transactionHistories.isEmpty()){
            return new ResponseEntity<List<TransactionHistory>>( HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TransactionHistory>>(transactionHistories, HttpStatus.OK);
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionHistory>> getCustomerTransaction(
            @RequestParam("barcode") String barcode, @RequestParam("transtype") String transType){
        List<TransactionHistory> transactionHistories = transactionHistoryService.findByBarcodeAndTransType(barcode, transType);
        if(transactionHistories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactionHistories, HttpStatus.OK);
    }
}
