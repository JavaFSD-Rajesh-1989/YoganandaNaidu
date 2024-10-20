package com.example.jwtokenpractise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordDTO {
	
	
	private String username; 
	
	private String newPassword; 

}
