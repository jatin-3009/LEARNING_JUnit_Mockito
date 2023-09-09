import com.mockito.Cashier;
import com.mockito.exception.IllegalArgumentException;
import com.mockito.exception.InvalidTransactionAmountException;
import org.junit.Test;

public class CashierTest {

    @Test(expected = IllegalArgumentException.class)
    public void validateTransactionThrowsIllegalArgument() {
        Cashier.validateTransaction("USD", 10);
    }

    @Test(expected = InvalidTransactionAmountException.class)
    public void validateTransactionAmountNegative() {
        Cashier.validateTransaction("EUR", -10);
    }
}
