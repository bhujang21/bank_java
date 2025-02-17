import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController  // This marks the class as a REST controller
@RequestMapping("/api")  // This sets the base path for all endpoints
public class AccountController {

    @Autowired
    private AccountService accountService;  // Use the service to handle business logic

    @PostMapping("/createAccount")  // This is the POST endpoint for creating an account
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/updateAccount/{accountNo}")  // This is the PUT endpoint for updating an account
    public Account updateAccount(@PathVariable String accountNo, @RequestBody Account account) {
        return accountService.updateAccount(accountNo, account);
    }

    @GetMapping("/viewPolicy/{accountNo}")  // This is the GET endpoint for viewing an account
    public Account viewPolicy(@PathVariable String accountNo) {
        return accountService.viewPolicy(accountNo);
    }

    @DeleteMapping("/deletePolicy/{accountNo}")  // This is the DELETE endpoint for deleting an account
    public void deletePolicy(@PathVariable String accountNo) {
        accountService.deletePolicy(accountNo);
    }
}
