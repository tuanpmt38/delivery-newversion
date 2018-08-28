package vn.shippo.delivery.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.shippo.delivery.model.DeliveryOrder;


@Repository
public interface DeliveryOrderRepository extends PagingAndSortingRepository<DeliveryOrder, Integer> {

    @Query(value = "select * from delivery_order d where d.barcode = ?1", nativeQuery = true)
    DeliveryOrder findByBarcode(String barcode);

    @Query(value = "select * from delivery_order d where (?1 or null) and(?2 or null) and(?3 or null)", nativeQuery = true)
    DeliveryOrder findByWhatever(String barcode, String orderState, String pickupContact);

}
