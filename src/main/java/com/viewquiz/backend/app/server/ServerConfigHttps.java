package com.viewquiz.backend.app.server;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//import org.apache.catalina.Context;
//import org.apache.catalina.connector.Connector;
//import org.apache.tomcat.util.descriptor.web.SecurityCollection;
//import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfigHttps {
	// @Bean
	// public EmbeddedServletContainerFactory servletContainer() {
	// TomcatEmbeddedServletContainerFactory tomcat = new
	// TomcatEmbeddedServletContainerFactory() {
	// @Override
	// protected void postProcessContext(Context context) {
	// SecurityConstraint securityConstraint = new SecurityConstraint();
	// securityConstraint.setUserConstraint("CONFIDENTIAL");
	// SecurityCollection collection = new SecurityCollection();
	// collection.addPattern("/*");
	// securityConstraint.addCollection(collection);
	// context.addConstraint(securityConstraint);
	// }
	// };
	//
	// tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
	// return tomcat;
	// }
	//
	// private Connector initiateHttpConnector() {
	// Connector connector = new
	// Connector("org.apache.coyote.http11.Http11NioProtocol");
	// connector.setScheme("http");
	// connector.setPort(8080);
	// connector.setSecure(false);
	// connector.setRedirectPort(8181);
	//
	// return connector;
	// }

	@Profile("!dev")
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		// tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	@Profile("dev")
	@Bean
	public EmbeddedServletContainerFactory servletContainerDev() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	@Value("${property.security.https.port}")
	private int httpsPort;

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		// connector.setPort(3000);
//		connector.setSecure(false);
//		// connector.setRedirectPort(80);
//		connector.setRedirectPort(httpsPort);
//		// connector.setRedirectPort(9002);
		
		connector.setScheme("http");
		connector.setPort(9000);
		connector.setSecure(false);
		connector.setRedirectPort(httpsPort);
		return connector;
	}
}
