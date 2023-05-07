package com.aa.testing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {

	private int id;
	private String name;
	private List<Integer> phoneNumber;

	public Employee(int id, String name, List<Integer> phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public static void main(String[] args) {
		List<Employee> employeeList = Employee.getEmployeeList();

		List<Integer> phoneNumberList = employeeList.stream().flatMap(employee -> employee.getPhoneNumber().stream()).collect(Collectors.toList());
		System.out.println(phoneNumberList);
	}

	public static List<Employee> getEmployeeList() {
		return Stream
				.of(new Employee(3, "Ram", Arrays.asList(666666, 777777, 1111111)),
						new Employee(4, "Pradeep", Arrays.asList(22222, 666666, 444444)),
						new Employee(1, "Shambavi", Arrays.asList(999999, 888888, 555555)))
				.collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<Integer> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
