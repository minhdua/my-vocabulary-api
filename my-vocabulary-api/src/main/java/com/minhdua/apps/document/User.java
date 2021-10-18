package com.minhdua.apps.document;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "User")
@NoArgsConstructor
public class User extends BaseEntity {
	@Indexed(unique = true)
	private String username;
	private String password;
	private String passwordRetyping;
	private Profile profile;
	@Default
	private Boolean isEnabled = true;
	@Default
	private Boolean isCredentialsNonExpired = true;
	@Default
	private Boolean isAccountNonLocked = true;
	@Default
	private Boolean isAccountNonExpired = true;
	@Default
	private Set<Role> roles = Set.of(Role.builder().shortName("USER").fullName("USER_ROLE").build());
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private LocalDateTime lastLoginDate;
}