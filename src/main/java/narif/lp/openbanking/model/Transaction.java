package narif.lp.openbanking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class Transaction {

    public enum Type {
        DEPOSIT_MONEY, WITHDRAW_MONEY;
    }

    private Type type;
    @EqualsAndHashCode.Exclude private Instant date;
    private Long accountNumber;
    private String currency;
    private BigDecimal amount;
    private String merchantName;
    private String merchantLogo;
}
