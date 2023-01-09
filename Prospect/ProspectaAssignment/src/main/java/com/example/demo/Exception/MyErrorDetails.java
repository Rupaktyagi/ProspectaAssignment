package com.example.demo.Exception;




import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyErrorDetails {

	private LocalTime time;
	
	private String message;
	
	private String desc;
	
}
