import com.example.BookNest.model.User;
import com.example.BookNest.repository.UserRepository;
import com.example.BookNest.exception.EmailAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BookNest.exception.EmailAlreadyExistsException;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
