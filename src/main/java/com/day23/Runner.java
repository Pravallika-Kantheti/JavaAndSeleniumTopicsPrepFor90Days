package com.day23;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Jatin", "QA", 10000);

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(new Employee(102, "Prava", "QA", 15000));
		empList.add(new Employee(103, "Lasya", "Dev", 16000));
		empList.add(new Employee(104, "Anil", "Dev", 17000));
		empList.add(new Employee(105, "Sravan", "DBA", 13000));

//		for (Employee tmp : empList) {
//			System.out.println(tmp);
//		}

		empList.forEach(e -> System.out.println(e));

		// Print all the employees who has the salary greater than 12000

		System.out.println("Employees who's salary more than 13000 from the list \n");
		empList.stream().filter(e -> e.getSalary() > 13000).forEach(e -> System.out.println(e));

		// Sort the list on the basis of the salary
		System.out.println("Sort the list on the basis of the salary \n");
		List<Employee> resultSortedBySalary = empList.stream()
				.sorted((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()))
				.collect(Collectors.toList());
		resultSortedBySalary.forEach(r -> System.out.println(r));
	}

}
