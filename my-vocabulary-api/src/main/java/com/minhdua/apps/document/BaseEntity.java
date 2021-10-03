package com.minhdua.apps.document;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEntity {
	@Id
	@Default
	private String id = UUID.randomUUID().toString();
	@Default
	private Boolean isDeleted = false;
}