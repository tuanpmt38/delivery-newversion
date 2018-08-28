package vn.shippo.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.shippo.delivery.model.Merchant;
import vn.shippo.delivery.repository.MerchantRepository;
import vn.shippo.delivery.service.MerchantService;

import java.util.List;
import java.util.Optional;

public class MerchantServiceImpl implements MerchantService {

    private MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository){
        this.merchantRepository = merchantRepository;
    }
    @Override
    public void save(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    @Override
    public Optional<Merchant> findById(Integer id) {
        return merchantRepository.findById(id);
    }

    @Override
    public List<Merchant> findAll() {
        return (List<Merchant>) merchantRepository.findAll();
    }
}
