package com.tsswebapps.lapinformatica.whatslap.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import io.github.bucket4j.local.LocalBucketBuilder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final Map<String, Bucket> cache = new ConcurrentHashMap<>();

    private Bucket createNewBucket() {
        return new LocalBucketBuilder()
                .addLimit(limit -> limit.capacity(5).refillIntervally(5, Duration.ofMinutes(1)))
                .build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String clientIp = request.getRemoteAddr();
        Bucket bucket = cache.computeIfAbsent(clientIp, k -> createNewBucket());

        if (bucket.tryConsume(1)) {
            String RequestUri = request.getRequestURI();
            if (!RequestUri.contains("/auth")) {
                String authorizationHeader = request.getHeader("Authorization");

                if (Objects.isNull(authorizationHeader) || authorizationHeader.isBlank()) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

                if (!authorizationHeader.startsWith("Bearer ")) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

                String token = authorizationHeader.substring(7);

                if(!JwtUtils.validateToken(token)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            }
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(429);
            response.getWriter().write("{\"error\": \"Muitas requisições. Tente novamente mais tarde.\"}");
        }
    }
}

