package com.zzh.admin.common.base.utils;

import com.zzh.admin.common.base.entity.SimpleUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import org.springframework.lang.NonNull;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

public class JwtUtil {

    private static final long DEFAULT_LIVED_SECONDS = 120 * 60L;
    private static final SecureDigestAlgorithm<SecretKey, SecretKey> SECRET_KEY_ALGORITHM = Jwts.SIG.HS256;
    private static final String KEY = "jwt@$_ye_jin_g_fen_g-zha_ng_zhi_hui_love";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(KEY.getBytes());


    public static String generateToken(@NonNull final SimpleUser user) {

        return generateToken(user, DEFAULT_LIVED_SECONDS);
    }

    public static String generateToken(@NonNull final SimpleUser user, @NonNull Long liveSeconds) {

        return Jwts.builder()
                .claim("userId", user.getUserId())
                .claim("tenantId", user.getTenantId())
                .expiration(Date.from(Instant.now().plusSeconds(liveSeconds)))
                .signWith(SECRET_KEY, SECRET_KEY_ALGORITHM)
                .compact();
    }

    public static Claims parseToken(@NonNull final String token) {
        return (Claims) Jwts.parser().verifyWith(SECRET_KEY).build().parse(token).getPayload();
    }

    private JwtUtil() {}
}
