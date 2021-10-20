package com.minhdua.apps;

import java.util.stream.Stream;

import com.minhdua.apps.constant.enums.ELanguage;
import com.minhdua.apps.constant.enums.ERole;
import com.minhdua.apps.constant.enums.EType;
import com.minhdua.apps.constant.enums.EUser;
import com.minhdua.apps.repository.LanguageReactiveRepository;
import com.minhdua.apps.repository.RoleReactiveRepository;
import com.minhdua.apps.repository.TypeReactiveRepository;
import com.minhdua.apps.repository.UserReactiveRepository;
import com.minhdua.apps.util.AuthUtils;
import com.minhdua.apps.util.UuidUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

import reactor.core.publisher.Mono;

@SpringBootApplication(scanBasePackages = { "com.minhdua.apps.repository", "com.minhdua.apps.service",
		"com.minhdua.apps.controller", "com.minhdua.apps.config", "com.minhdua.apps.util", "com.minhdua.apps.functions",
		"com.minhdua.apps.router", "com.minhdua.apps.validation" })
@EnableReactiveMongoAuditing
public class VocabularyApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(VocabularyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VocabularyApplication.class, args);
	}

	@Autowired
	UserReactiveRepository userRepository;

	@Autowired
	RoleReactiveRepository roleRepository;

	@Autowired
	LanguageReactiveRepository langRepository;

	@Autowired
	TypeReactiveRepository typeRepository;

	@Autowired
	AuthUtils authUtils;

	@Value("${com.minhdua.apps.load-data}")
	boolean isLoad;

	@Override
	public void run(String... args) throws Exception {
		if (isLoad) {
			loadData();
		}
	}

	private void loadData() {
		LOG.info("Saving System User");
		for (EUser u : EUser.values()) {
			var user = u.getUser();
			authUtils.userDefault(user.getUsername(), user.getPassword()).flatMap(userDefault -> {
				return userRepository.findByUsername(user.getUsername()).defaultIfEmpty(userDefault).flatMap(usr -> {
					if (usr.getId() == null) {
						usr.setId(UuidUtils.uuid());
						return userRepository.save(usr);
					}
					return Mono.just(usr);
				});
			}).block();
		}

		LOG.info("Saving System Role");
		Stream.of(ERole.values()).forEach(eRole -> {
			var role = eRole.getRole();
			roleRepository.findByFullName(role.getFullName()).defaultIfEmpty(role).flatMap(rol -> {
				if (rol.getId() == null) {
					rol.setId(UuidUtils.uuid());
					return roleRepository.save(rol);
				}
				return Mono.just(rol);
			}).block();
		});

		LOG.info("Saving System Language");
		Stream.of(ELanguage.values()).forEach(eLang -> {
			var lang = eLang.getLanguage();
			langRepository.findByFullName(lang.getFullName()).defaultIfEmpty(lang).flatMap(la -> {
				if (la.getId() == null) {
					la.setId(UuidUtils.uuid());
					return langRepository.save(la);
				}
				return Mono.just(la);
			}).block();
		});

		LOG.info("Saving System Type");
		Stream.of(EType.values()).forEach(eType -> {
			var type = eType.getType();
			typeRepository.findByFullName(type.getFullName()).defaultIfEmpty(type).flatMap(typ -> {
				if (typ.getId() == null) {
					typ.setId(UuidUtils.uuid());
					return typeRepository.save(typ);
				}
				return Mono.just(typ);
			}).block();
		});
	}
}
