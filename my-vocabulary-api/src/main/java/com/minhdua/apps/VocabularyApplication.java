package com.minhdua.apps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.minhdua.apps.repository", "com.minhdua.apps.service",
		"com.minhdua.apps.controller", "com.minhdua.apps.config", "com.minhdua.apps.util", "com.minhdua.apps.functions",
		"com.minhdua.apps.router", })
public class VocabularyApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(VocabularyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VocabularyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");
	}

}
