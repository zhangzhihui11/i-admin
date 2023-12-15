package com.zzh.admin.gateway.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzh.admin.common.base.exception.BizException;
import com.zzh.admin.common.base.response.Resp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Order(-1)
@RequiredArgsConstructor
@Component
public class JsonExceptionHandler implements ErrorWebExceptionHandler {

    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();
        if (response.isCommitted()) {

            return Mono.error(ex);
        }
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if (ex instanceof ResponseStatusException) {
            response.setStatusCode(((ResponseStatusException) ex).getStatus());
        }

        return response.writeWith(Mono.fromSupplier(()-> {
            DataBufferFactory dataBufferFactory = response.bufferFactory();
            try {
                return dataBufferFactory.wrap(objectMapper.writeValueAsBytes(buildErrorJsonResponse(ex)));
            } catch (JsonProcessingException e) {
                return dataBufferFactory.wrap(new byte[0]);
            }
        }));
    }

    private Resp<Object> buildErrorJsonResponse(Throwable ex) {
        if (ex instanceof BizException) {
            BizException e = (BizException) ex;
            return Resp.buildResp(e.getCode(), e.getMessage(), null);
        }
        if (ex instanceof ResponseStatusException) {
            ResponseStatusException e = (ResponseStatusException) ex;
            return Resp.buildResp(e.getStatus().value(), e.getMessage(), null);
        }
        return Resp.failed();
    }
}
