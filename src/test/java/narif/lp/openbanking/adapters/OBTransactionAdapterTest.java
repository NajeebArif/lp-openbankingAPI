package narif.lp.openbanking.adapters;

import com.acme.banking.model.OBActiveOrHistoricCurrencyAndAmount9;
import com.acme.banking.model.OBCreditDebitCode1;
import com.acme.banking.model.OBMerchantDetails1;
import com.acme.banking.model.OBTransaction6;
import narif.lp.openbanking.model.Transaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Adapter Specs:")
class OBTransactionAdapterTest {

    public static final String ACCOUNT_ID = "123456789";
    private OBTransactionAdapter adapter = new OBTransactionAdapter();

    @Test
    @DisplayName("Given a Credit Debit Type, transaction type should be populated.")
    public void testTransactionType(){
        final var obTransaction6 = createObTransaction().creditDebitIndicator(OBCreditDebitCode1.DEBIT);
        var transaction = adapter.mapToTransaction(obTransaction6);
        assertThat(transaction).isNotNull()
                .matches(t->t.getType().equals(Transaction.Type.DEBIT));
        obTransaction6.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);
        transaction = adapter.mapToTransaction(obTransaction6);
        assertThat(transaction).isNotNull()
                .matches(t->t.getType().equals(Transaction.Type.CREDIT));
    }

    @Test
    @DisplayName("If account id is present in OBTransaction6 then transaction should contain it.")
    public void testAccountIdPresent(){
        final var transaction = adapter.mapToTransaction(createObTransaction());
        assertThat(transaction).isNotNull()
                .matches(t->t.getAccountNumber().equals(Long.parseLong(ACCOUNT_ID)));
    }

    @Test
    public void returnsTransaction(){
        final var transaction = adapter.mapToTransaction(createObTransaction());
        assertThat(transaction).isNotNull();
    }

    private OBTransaction6 createObTransaction(){
        final var obTransaction6 = new OBTransaction6().accountId(ACCOUNT_ID);
        return obTransaction6;
    }

    @Test
    public void testNullMerchant() {
        var ob = new OBTransaction6();
        ob.setAccountId("1234567");
        ob.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        ob.setAmount(amount());
        var t = adapter.adapt(ob);
        assertEquals(null, t.getMerchantName());
    }

    @Test
    public void testMerchant() {
        var ob = new OBTransaction6();
        ob.setAccountId("1234567");
        ob.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        ob.setAmount(amount());
        ob.setMerchantDetails(merchantDetails());
        var t = adapter.adapt(ob);
        assertEquals("acme", t.getMerchantName());
    }

    @Test
    public void testInvalidAmount() {
        var ob = new OBTransaction6();
        ob.setAccountId("1234567");
        ob.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        ob.setAmount(invalidAmount());
        var t = adapter.adapt(ob);
        assertEquals(0.0d, t.getAmount());
    }

    @Test
    public void testAmount() {
        var ob = new OBTransaction6();
        ob.setAccountId("1234567");
        ob.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);
        ob.setAmount(amount());
        var t = adapter.adapt(ob);
        assertEquals(100.0d, t.getAmount());
    }

    private OBActiveOrHistoricCurrencyAndAmount9 amount() {
        var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setAmount("100.00");
        amount.setCurrency("USD");
        return amount;
    }

    private OBActiveOrHistoricCurrencyAndAmount9 invalidAmount() {
        var amount = new OBActiveOrHistoricCurrencyAndAmount9();
        amount.setCurrency("100.00");
        amount.setAmount("USD");
        return amount;
    }

    private OBMerchantDetails1 merchantDetails() {
        var m = new OBMerchantDetails1();
        m.setMerchantName("acme");
        m.setMerchantCategoryCode("25");
        return m;
    }
}