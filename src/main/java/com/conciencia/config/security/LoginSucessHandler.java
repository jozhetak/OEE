package com.conciencia.config.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;


@Service
public class LoginSucessHandler extends
        SavedRequestAwareAuthenticationSuccessHandler {
    
    private static final int ONE_HOUR_TIMEOUT = 3600;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                    HttpServletResponse response, Authentication authentication)
                                        throws ServletException, IOException {
        
        request.getSession().setMaxInactiveInterval(ONE_HOUR_TIMEOUT);
        super.onAuthenticationSuccess(request, response, authentication);
    }

}