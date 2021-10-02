package com.minhdua.apps.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "CommonLanguage")
public class Language extends AuditEntity {
	@Indexed(unique = true)
	private String shortName;
	private String fullName;
	private String localName;
}