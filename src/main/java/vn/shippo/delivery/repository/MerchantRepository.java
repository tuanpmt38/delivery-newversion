package vn.shippo.delivery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.shippo.delivery.model.Merchant;

public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Integer> {
}
