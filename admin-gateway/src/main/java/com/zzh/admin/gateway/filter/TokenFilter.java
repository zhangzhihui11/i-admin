package com.zzh.admin.gateway.filter;

import com.alibaba.fastjson2.JSON;
import com.zzh.admin.common.base.constants.RequestHeader;
import com.zzh.admin.common.base.entity.SimpleUser;
import com.zzh.admin.common.base.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
@Slf4j
@RefreshScope
public class TokenFilter implements GlobalFilter, Ordered {

    @Value("${white.path}")
    private Set<String> whitePath;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestPath = exchange.getRequest().getPath().value();
        log.info("requestPath is {}", requestPath);
        if (whitePath.contains(requestPath)) {
            return chain.filter(exchange);
        }
        List<String> tokens = exchange.getRequest().getHeaders().get(RequestHeader.TOKEN_KEY);
        if (tokens == null || tokens.isEmpty()) {
            throw new IllegalStateException("Token is empty");
        }
        String token = tokens.get(0);
        if (null != token) {
            Claims claims = JwtUtil.parseToken(token);
            SimpleUser simpleUser = new SimpleUser();
            simpleUser.setAccount(claims.get("userAccount", String.class));
            simpleUser.setUserId(claims.get("userId", Long.class));
            ServerHttpRequest newRequest = exchange.getRequest().mutate().header(RequestHeader.SIMPLE_USER_KEY, JSON.toJSONString(simpleUser)).build();
            return chain.filter(exchange.mutate().request(newRequest).build());
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @PostConstruct
    public void logWhitePath() {
        log.info("whitePath is {}", whitePath);
    }
}
