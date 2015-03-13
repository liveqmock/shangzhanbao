package com.itour.etip.pub.kit.cas;

//import org.jasig.cas.authentication.handler.AuthenticationException;
//import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
//import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
//import org.springframework.util.StringUtils;

/**
 * Simple test implementation of a AuthenticationHandler that returns true if
 * the username and password match. This class should never be enabled in a
 * production environment and is only designed to facilitate unit testing and
 * load testing.
 * 
 * @author Scott Battaglia
 * @version $Revision: 42053 $ $Date: 2007-06-10 09:17:55 -0400 (Sun, 10 Jun 2007) $
 * @since 3.0
 */
public final class EtipUsernamePasswordAuthenticationHandler {
	/*

	extends
    AbstractUsernamePasswordAuthenticationHandler {

    public UsernamePasswordAuthenticationHandler() {
        log
            .warn(this.getClass().getName()
                + " is only to be used in a testing environment.  NEVER enable this in a production environment.");
    }
    private AbstractUsernamePasswordAuthenticationHandler webHandler;
    private AbstractUsernamePasswordAuthenticationHandler ccHandler;

    public boolean authenticateUsernamePasswordInternal(
        final UsernamePasswordCredentials credentials) {
        final String username = credentials.getUsername();
        final String password = credentials.getPassword();

        if (StringUtils.hasText(username) && StringUtils.hasText(password)) {
        	if (username.indexOf("&")>0){
        		try {
    				return webHandler.authenticate(credentials);
    			} catch (AuthenticationException e) {
    				
    				return false;
    			}
        	}
        	else{
        		try {
    				return ccHandler.authenticate(credentials);
    			} catch (AuthenticationException e) {
    				
    				return false;
    			}
        	}
        }

        log.debug("User [" + username + "] failed authentication");

        return false;
    }

	public void setWebHandler(AbstractUsernamePasswordAuthenticationHandler webHandler) {
		this.webHandler = webHandler;
	}

	public AbstractUsernamePasswordAuthenticationHandler getWebHandler() {
		return webHandler;
	}

	public void setCcHandler(AbstractUsernamePasswordAuthenticationHandler ccHandler) {
		this.ccHandler = ccHandler;
	}

	public AbstractUsernamePasswordAuthenticationHandler getCcHandler() {
		return ccHandler;
	}*/
}