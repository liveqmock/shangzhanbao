/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.itour.etip.security.intercept.webservice;

import java.net.URL;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.intercept.AbstractSecurityInterceptor;
import org.springframework.security.intercept.InterceptorStatusToken;
import org.springframework.security.intercept.ObjectDefinitionSource;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.ui.cas.CasProcessingFilter;

/**
 * Performs security handling of HTTP resources via a filter implementation.
 * <p>
 * The <code>ObjectDefinitionSource</code> required by this security
 * interceptor is of type {@link FilterInvocationDefinitionSource}.
 * </p>
 * <p>
 * Refer to {@link AbstractSecurityInterceptor} for details on the workflow.
 * </p>
 * 
 * @author Ben Alex
 * @version $Id: FilterSecurityInterceptor.java 2479 2008-01-19 13:51:03Z luke_t $
 */
public class WebServiceSecurityInterceptor extends AbstractSecurityInterceptor {
	// ~ Instance fields
	// ================================================================================================

	private FilterInvocationDefinitionSource objectDefinitionSource;

	// ~ Methods
	// ========================================================================================================

	/**
	 * Not used (we rely on IoC container lifecycle services instead)
	 * 
	 * @param arg0
	 *            ignored
	 * 
	 * @throws ServletException
	 *             never thrown
	 */
	public void init(FilterConfig arg0) throws ServletException {
	}

	/**
	 * Not used (we rely on IoC container lifecycle services instead)
	 */
	public void destroy() {
	}

	public FilterInvocationDefinitionSource getObjectDefinitionSource() {
		return this.objectDefinitionSource;
	}

	public Class getSecureObjectClass() {
		return URL.class;
	}

	public boolean invoke(String username, String password, String url) {
		URL fi;
		try {
			fi = new URL(url);
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
					CasProcessingFilter.CAS_STATELESS_IDENTIFIER, password);
			SecurityContextHolder.getContext().setAuthentication(authRequest);
			InterceptorStatusToken token = super.beforeInvocation(fi);
			if (!token.getAuthentication().getName().equalsIgnoreCase(username)) {
				return false;
			}
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}

	public ObjectDefinitionSource obtainObjectDefinitionSource() {
		return this.objectDefinitionSource;
	}

	public void setObjectDefinitionSource(
			FilterInvocationDefinitionSource newSource) {
		this.objectDefinitionSource = newSource;
	}

}
