package com.minhdua.apps.document;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "User")
public class User extends BaseEntity{
	private String username;
	private String password;
	private Profile profile;
	private Boolean isActive;
	private Role roles;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private LocalDateTime lastLoginDate;
}