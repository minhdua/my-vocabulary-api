package com.minhdua.apps.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "TypeOfWord")
public class Type extends AuditEntity {
	private String shortName;
	private String fullName;
}