package com.example.demo.model;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {

	private int count;
	
	private List<Entry> entries;
	
}
