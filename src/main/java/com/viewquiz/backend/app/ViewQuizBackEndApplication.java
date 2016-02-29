package com.viewquiz.backend.app;

import java.awt.Toolkit;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan
public class ViewQuizBackEndApplication {
	private static final Logger logger = LoggerFactory.getLogger(ViewQuizBackEndApplication.class);

	public static void main(String[] args) {
		// Booster.Boost();
		DropBoxBooster dropBoxBooster = new DropBoxBooster();
		dropBoxBooster.checkDirectoryVersion();
		ViewQuizBackEndApplication.TestLogger();
		ApplicationContext ctx = SpringApplication.run(ViewQuizBackEndApplication.class, args);
		ViewQuizBackEndApplication.beansInspect(ctx);
		startUpNotification();
	}

	private static void startUpNotification() {
		// final Runnable runnable = (Runnable)
		// Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");
		final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.hand");
		if (runnable != null) {
			runnable.run();
		}
	}

	private static void beansInspect(ApplicationContext ctx) {
		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
			Log.D(beanName);
		}
		Log.W("server is started");
	}

	private static void TestLogger() {

		logger.error("Message logged at ERROR level");
		Log.E("Message logged at ERROR level");

		logger.warn("Message logged at WARN level");
		Log.W("Message logged at WARN level");

		logger.info("Message logged at INFO level");
		Log.I("Message logged at INFO level");

		logger.debug("Message logged at DEBUG level");
		Log.D("Message logged at DEBUG level");

	}
}
