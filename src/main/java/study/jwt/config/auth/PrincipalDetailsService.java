package study.jwt.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import study.jwt.model.User;
import study.jwt.repository.UserRepository;

// http://localhost:8080/login => 동작안함
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //스프링이 로그인 요청을 가로챌 때, username, password 변수 2개를 가로챈느데
    // password 부분 처리는 알아서 함
    // username이 DB에 있는지만 확인해주면 됨.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailService : 진입");
        User user = userRepository.findByUsername(username);

        return new PrincipalDetails(user); //시큐리티의 세션에 유저 정보가 저장이 됨
    }
}
