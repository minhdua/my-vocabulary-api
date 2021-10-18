package com.minhdua.apps.config;

import java.util.stream.Collectors;

import com.minhdua.apps.document.Role;
import com.minhdua.apps.document.User;
import com.minhdua.apps.dto.UserInfoPublic;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@Bean
	ModelMapper getModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.typeMap(User.class, UserInfoPublic.class).addMappings(new PropertyMap<User, UserInfoPublic>() {
			@Override
			protected void configure() {
				when(ctx -> ((User) ctx.getSource()).getProfile() != null)
						.using(ctx -> ((User) ctx.getSource()).getProfile().getFirstName())
						.map(source, destination.getFirstName());
				when(ctx -> ((User) ctx.getSource()).getProfile() != null)
						.using(ctx -> ((User) ctx.getSource()).getProfile().getLastName())
						.map(source, destination.getLastName());
				when(ctx -> ((User) ctx.getSource()).getProfile() != null)
						.using(ctx -> ((User) ctx.getSource()).getProfile().getPhoto())
						.map(source, destination.getPhoto());
				when(ctx -> !((User) ctx.getSource()).getRoles().isEmpty()).using(ctx -> {
					var roles = ((User) ctx.getSource()).getRoles();
					return roles.stream().map(Role::getFullName).collect(Collectors.toSet());
				}).map(source, destination.getRoles());
			}
		});
		return modelMapper;
	}
}