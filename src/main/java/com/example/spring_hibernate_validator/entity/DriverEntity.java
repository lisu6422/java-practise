package com.example.spring_hibernate_validator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverEntity {
	@NotBlank
	public String name;

	@Min(
		value = 18,
		message = "You have to be 18 to drive a car",
		groups = GroupA.class
	)
	public int age;

	@AssertTrue(
		message = "You first have to pass the driving test",
		groups = GroupA.class
	)
	public boolean hasDrivingLicense;
}
