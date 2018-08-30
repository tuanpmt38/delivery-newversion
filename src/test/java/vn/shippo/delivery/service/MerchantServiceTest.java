package vn.shippo.delivery.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vn.shippo.delivery.repository.MerchantRepository;

@RunWith(SpringJUnit4ClassRunner.class)

public class MerchantServiceTest {

    @Mock
    private MerchantService merchantService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    public MerchantRepository merchantRepository() {
        return Mockito.mock(MerchantRepository.class);
    }

    //Todo

}
