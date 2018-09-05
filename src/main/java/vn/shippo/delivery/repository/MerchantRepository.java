package vn.shippo.delivery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.shippo.delivery.model.Merchant;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Integer> {
}
