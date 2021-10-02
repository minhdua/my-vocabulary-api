package com.minhdua.apps.document;

import lombok.experimental.SuperBuilder;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "TypeOfWord")
public class Type extends AuditEntity {
	private String shortName;
	private String fullName;
}