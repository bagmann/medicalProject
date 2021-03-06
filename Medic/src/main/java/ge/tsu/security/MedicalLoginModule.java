package ge.tsu.security;

import ge.tsu.server.ejb.AuthorizationLocal;
import org.apache.log4j.Logger;
import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginException;
import java.security.acl.Group;

/**
 * Created by Vako on 5/9/2014.
 */
public class MedicalLoginModule extends UsernamePasswordLoginModule {
	public static final String MEDICAL_SECURITY_DOMAIN = "MedicalSecurityDomain";
	private static final String MEDICAL_WEB_USER = "medical.web.user";

	Logger logger = Logger.getLogger(getClass());

	@Override
	protected String getUsersPassword() throws LoginException {

		String login = super.getUsername().trim();
		String password = super.getUsernameAndPassword()[1];

		logger.info("Attempt to login: " + login);

		// FIXME this if will be while development
		if (login.equals("sa")) {
			return "sa";
		}

		return getAuthorizationLocal().checkUser(login, password);
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {

		// The declarative permissions
		Group roles = new SimpleGroup("Roles");

		Group[] groups = {roles};

		SimplePrincipal role = new SimplePrincipal(MEDICAL_WEB_USER);
		roles.addMember(role);

		return groups;
	}

	private AuthorizationLocal getAuthorizationLocal() throws LoginException {
		try {
			InitialContext ic = new InitialContext();
			Object object = ic.lookup("java:global/Medic/AuthorizationSession!ge.tsu.server.ejb.AuthorizationLocal");
			return (AuthorizationLocal) object;
		} catch (NamingException e) {
			log.error(e.getMessage(), e);
			throw new LoginException(e.toString(true));
		}
	}
}
