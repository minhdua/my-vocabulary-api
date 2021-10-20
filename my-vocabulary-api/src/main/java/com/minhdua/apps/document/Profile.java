package com.minhdua.apps.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile{
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@Default
	private String photo = "static/photo/default/default_avatar.png";
}
