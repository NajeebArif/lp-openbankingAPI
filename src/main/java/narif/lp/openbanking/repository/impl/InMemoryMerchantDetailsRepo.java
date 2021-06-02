package narif.lp.openbanking.repository.impl;

import narif.lp.openbanking.repository.MerchantDetailsRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryMerchantDetailsRepo implements MerchantDetailsRepo {
    @Override
    public Optional<String> findMerchantLogo(String merchantName) {
        if (merchantName == null) {
            return Optional.empty();
        }

        return Optional.of(merchantName + ".png");
    }
}
