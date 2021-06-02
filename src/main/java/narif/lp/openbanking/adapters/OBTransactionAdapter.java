package narif.lp.openbanking.adapters;

import com.acme.banking.model.OBCreditDebitCode1;
import com.acme.banking.model.OBTransaction6;
import narif.lp.openbanking.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

public class OBTransactionAdapter {

    public Transaction mapToTransaction(OBTransaction6 obTransaction6){
        return adapt(obTransaction6);
    }

    Transaction adapt(final OBTransaction6 transaction6) {
        return transactionFunction.apply(transaction6);
    }

    private final Function<OBTransaction6, Transaction> transactionFunction = obTransaction6 -> {
        var t = new Transaction();
        t.setAccountNumber(Long.valueOf(obTransaction6.getAccountId()));

        var amount = tryAndApply(obTransaction6, o -> Double.valueOf(o.getAmount().getAmount()));
        var fx = tryAndApply(obTransaction6, o -> o.getCurrencyExchange().getExchangeRate().doubleValue());
        t.setAmount(BigDecimal.valueOf(amount.orElse(0.0) * fx.orElse(1.0)));

        tryAndApply(obTransaction6, o -> obTransaction6.getCurrencyExchange().getUnitCurrency())
                .ifPresent(t::setCurrency);
        tryAndApply(obTransaction6, o -> obTransaction6.getCreditDebitIndicator().toString())
                .ifPresent(t::setTransactionType);
        tryAndApply(obTransaction6, o -> obTransaction6.getMerchantDetails().getMerchantName())
                .ifPresent(t::setMerchantName);
        tryAndApply(obTransaction6, o -> new Date(obTransaction6.getValueDateTime().toLocalDate().toEpochDay()))
                .ifPresent(t::setInstantFromDate);
        return t;
    };

    private <T> Optional<T> tryAndApply(final OBTransaction6 transaction6, Function<OBTransaction6, T> func) {
        try {
            return Optional.of(func.apply(transaction6));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
