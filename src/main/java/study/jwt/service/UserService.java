package study.jwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.jwt.dto.JoinRequestDto;
import study.jwt.model.User;
import study.jwt.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void Join(JoinRequestDto joinRequestDto){

        String encodePassword = bCryptPasswordEncoder.encode(joinRequestDto.getPassword());
        User user = User.createUser(joinRequestDto.getUsername(), encodePassword, joinRequestDto.getRole());
        userRepository.save(user);
    }
}
