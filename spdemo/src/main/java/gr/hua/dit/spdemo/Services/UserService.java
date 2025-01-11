package gr.hua.dit.spdemo.Services;

import gr.hua.dit.spdemo.Models.User;
import gr.hua.dit.spdemo.Models.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User registerUser(User user) {
        // Εικονική υλοποίηση
        return user;
    }

    public String authenticateUser(LoginRequest loginRequest) {
        // Εικονική υλοποίηση
        return "fake-jwt-token";
    }

    public User getUserById(long id) {
        // Εικονική υλοποίηση
        return new User();
    }

    public User updateUser(Long id, User user) {
        // Εικονική υλοποίηση
        return user;
    }

    public void deleteUser(long id) {
        // Εικονική υλοποίηση
    }
}
