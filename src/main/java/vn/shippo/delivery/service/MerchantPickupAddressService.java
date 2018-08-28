package vn.shippo.delivery.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.shippo.delivery.model.MerchantPickupAddress;

import java.util.List;
import java.util.Optional;

public interface MerchantPickupAddressService {

    Page<MerchantPickupAddress> findAll(Pageable pageable);

    List<MerchantPickupAddress> findAll();

    Optional<MerchantPickupAddress> findById(Integer id);

    MerchantPickupAddress save(MerchantPickupAddress merchantPickupAddress);

    void delete(Integer id);

    MerchantPickupAddress findByContactName(String contactName);


    boolean exists(MerchantPickupAddress merchantPickupAddress) ;

    MerchantPickupAddress findAllByPickupContactName(String pickupContactName);
}
