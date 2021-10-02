package com.minhdua.apps.document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Profile {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String photo;
}
