import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service  // This marks the class as a service class in Spring
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;  // This is the repository that lets us interact with the database

    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);  // Save the account to the database
    }

    @Transactional
    public Account updateAccount(String accountNo, Account account) {
        Account existingAccount = accountRepository.findById(accountNo).orElseThrow(() -> new RuntimeException("Account not found"));
        existingAccount.setPolicyName(account.getPolicyName());
        existingAccount.setPolicyDetails(account.getPolicyDetails());
        return accountRepository.save(existingAccount);  // Save the updated account
    }

    @Transactional(readOnly = true)
    public Account viewPolicy(String accountNo) {
        return accountRepository.findById(accountNo).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Transactional
    public void deletePolicy(String accountNo) {
        accountRepository.deleteById(accountNo);  // Delete the account from the database
    }
}
