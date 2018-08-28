package vn.shippo.delivery.service;

import vn.shippo.delivery.model.DeliveryOrder;

import java.util.Optional;

public interface DeliveryOrderService {


    Optional<DeliveryOrder> findById(Integer id);

    DeliveryOrder findByBarcode(String barcode);

    Iterable<DeliveryOrder> findAll();
}
