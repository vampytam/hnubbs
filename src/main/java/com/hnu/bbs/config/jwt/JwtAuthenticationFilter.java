package com.hnu.bbs.config.jwt;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.springframework.util.PathMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            if(isProtectedUrl(request)) {
                if(!request.getMethod().equals("OPTIONS"))
                    request = JwtUtil.validateTokenAndAddUserIdToHeader(request);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        List<String> protectedPaths = new ArrayList<String>();
        protectedPaths.add("/user/info");
        protectedPaths.add("/user/update");
        protectedPaths.add("/post/create");
        protectedPaths.add("/post/update");
        protectedPaths.add("/post/delete/*");
        protectedPaths.add("/comment/add-comment");
        protectedPaths.add("/follow/subscribe/*");
        protectedPaths.add("/follow/unsubscribe/*");
        protectedPaths.add("/follow/validate/*");

        boolean bFind = false;
        for( String passedPath : protectedPaths ) {
            bFind = pathMatcher.match(passedPath, request.getServletPath());
            if( bFind ) {
                break;
            }
        }
        return bFind;
    }

}
