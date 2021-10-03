package com.minhdua.apps.document;

import lombok.experimental.SuperBuilder;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "Translation")
public class Translation extends BaseEntity {
	private Type type;
	private String pronunciation;
	private String destinationLanguage;
	private String mean;
}