package vn.shippo.delivery.service;

import vn.shippo.delivery.model.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    Merchant save(Merchant merchant);

    Optional<Merchant> findById(Integer id);

    List<Merchant> findAll();
}
