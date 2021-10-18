package com.minhdua.apps.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "CommonLanguage")
@AllArgsConstructor
@NoArgsConstructor
public class Language extends AuditEntity {
	@Indexed(unique = true)
	private String shortName;
	private String fullName;
	private String localName;
}