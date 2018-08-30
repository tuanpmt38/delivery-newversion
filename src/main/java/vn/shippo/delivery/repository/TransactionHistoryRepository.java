package vn.shippo.delivery.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.shippo.delivery.model.TransactionHistory;

import java.sql.Timestamp;
import java.util.List;
    @Repository
    public interface TransactionHistoryRepository extends PagingAndSortingRepository<TransactionHistory, Integer>{

        @Query(value = "select * from transaction_histories t where t.barcode = ?1", nativeQuery = true)
        List<TransactionHistory> findByBarcode(String barcode);

        @Query(value = "select * from transaction_histories t where t.create_at between ?1 and ?2",nativeQuery = true)
        List<TransactionHistory> findAllByCreatedAtBetween(Timestamp createAt);

        @Query(value = "select * from transaction_histories t where t.transe_type =?1 ",nativeQuery = true)
        List<TransactionHistory> findAllByTransType(String transType);

        @Query(value = "select * from transaction_histories t " +
                "where t.barcode = ?1" +
                " or t.trans_type = ?2"
                , nativeQuery = true)
        List<TransactionHistory> findByBarcodeAndTransType(String barcode, String transType);

    }

