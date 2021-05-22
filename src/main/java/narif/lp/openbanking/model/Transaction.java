package narif.lp.openbanking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "transactions_table")
public class Transaction {

    public enum Type {
        CREDIT, DEBIT;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @EqualsAndHashCode.Exclude
    private Instant date;

    private Long accountNumber;

    private String currency;

    private BigDecimal amount;

    private String merchantName;

    private String merchantLogo;
}
