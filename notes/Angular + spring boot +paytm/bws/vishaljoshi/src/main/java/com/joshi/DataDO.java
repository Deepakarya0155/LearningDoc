package com.joshi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class DataDO {
	
	@NonNull
	LocalDate date;
	@NonNull
	Long d1;
	@NonNull
	Long d2;
	@NonNull
	Long d3;
	@NonNull
	Long d4;
	@NonNull
	Long d5;
	@NonNull
	Long d6;
	@NonNull
	Long d7;
	
	
	public List<Long> getList(){
		List<Long> ls=Arrays.asList(d1,d2,d3,d4,d5,d6,d7);
		return ls;
	}
	
}
