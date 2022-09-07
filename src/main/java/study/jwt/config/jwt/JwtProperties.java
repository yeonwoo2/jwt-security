package study.jwt.config.jwt;

public interface JwtProperties {
    String SECRET = "이현우";
    int EXPIRATION_TIME = 60000 * 10; // 10일 (1/1000초)
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
