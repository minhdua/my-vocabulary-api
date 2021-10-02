package com.minhdua.apps.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseEntity {
	private String id;
	private LocalDateTime updateDate;
	private LocalDateTime createDate;
	private String updateBy;
	private String createBy;
}