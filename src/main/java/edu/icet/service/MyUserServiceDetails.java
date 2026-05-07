package edu.icet.service;

import edu.icet.model.User;
import edu.icet.model.UserPrinciple;
import edu.icet.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MyUserServiceDetails implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUser = userRepository.findByName(username);
        if (byUser == null) {
            throw new UsernameNotFoundException("User not found" + byUser.getName());
        }
        return new UserPrinciple(byUser);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}