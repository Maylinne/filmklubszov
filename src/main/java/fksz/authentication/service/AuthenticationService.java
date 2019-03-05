package fksz.authentication.service;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class AuthenticationService {
	public boolean isUserAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null && authentication.isAuthenticated();
	}

	public boolean isUserAdmin() {
		boolean result = false;
		if (isUserAuthenticated()) {
			result = checkAdmin();
		}
		return result;
	}

	private boolean checkAdmin() {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		boolean result = false;
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("ROLE_ADMIN")) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public static void isLoginOk(BindingResult bindingResult, HttpSession httpSession) {
		Throwable authException = (Throwable) httpSession.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (authException != null) {
			bindingResult.reject(authException.getMessage(), authException.getMessage());
			httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
	}
}
