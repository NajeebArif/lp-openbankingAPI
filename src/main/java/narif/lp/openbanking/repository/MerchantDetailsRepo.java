package narif.lp.openbanking.repository;

import java.util.Optional;

public interface MerchantDetailsRepo {
    Optional<String> findMerchantLogo(final String merchantName);
}
