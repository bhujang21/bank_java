import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AccountServiceTests {

    @Autowired
    private AccountService accountService;

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        account.setAccountNo("12345");
        account.setPolicyName("Health");
        account.setPolicyDetails("Health insurance policy");

        Account createdAccount = accountService.createAccount(account);

        assertThat(createdAccount).isNotNull();
        assertThat(createdAccount.getAccountNo()).isEqualTo("12345");
    }

    @Test
    public void testUpdateAccount() {
        Account account = accountService.viewPolicy("12345");
        account.setPolicyName("Updated Policy");
        Account updatedAccount = accountService.updateAccount(account.getAccountNo(), account);

        assertThat(updatedAccount.getPolicyName()).isEqualTo("Updated Policy");
    }

    @Test
    public void testDeletePolicy() {
        accountService.deletePolicy("12345");
        boolean exists = accountRepository.existsById("12345");
        assertThat(exists).isFalse();
    }
}
