package com.minhdua.apps.document;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.experimental.SuperBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Document(collection = "Structure")
public class Structure extends AuditEntity{
	private String formula;
	private String description;
	private Set<String> documentReferences;
}