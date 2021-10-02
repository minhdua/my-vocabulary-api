package com.minhdua.apps.document;

import lombok.experimental.SuperBuilder;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "Role")
public class Role extends AuditEntity{
	private String shortName;
	private String fullName;
}
