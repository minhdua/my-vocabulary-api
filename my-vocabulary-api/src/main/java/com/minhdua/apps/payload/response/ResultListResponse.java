package com.minhdua.apps.payload.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class ResultListResponse<T> extends BaseResponse<T> {

	protected List<T> data;

	@Getter(AccessLevel.NONE)
	protected long recordNum;

	public long getRecordNum() {
		return data.size();
	}
}