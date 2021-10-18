package com.minhdua.apps.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@Document(collection = "Role")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AuditEntity {
	private String shortName;
	private String fullName;
}
