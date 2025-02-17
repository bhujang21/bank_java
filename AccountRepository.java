import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
    // This is a special interface that allows us to interact with the Account table in the database
}
