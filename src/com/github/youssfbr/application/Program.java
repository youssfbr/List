package com.github.youssfbr.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.github.youssfbr.entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int numberEmployees = sc.nextInt();

		for (int i = 0; i < numberEmployees; i++) {

			System.out.println();
			System.out.println("Employee #" + (i + 1) + " :");

			System.out.print("Id: ");
			Integer id = sc.nextInt();

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			list.add(new Employee(id, name, salary));
		}

		System.out.println();
		System.out.print("Enter the employee id thar will have salary increase: ");
		int idSalary = sc.nextInt();
		Integer pos = position(list, idSalary);

		if (pos == null) {
			System.out.println("This id does not exist!");
		} 
		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);

			System.out.println();
			System.out.println("List of employees:");
			
			for (Employee emp : list) {
				System.out.println(emp);
			}			
		}
		sc.close();
	}
	
	private static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
}
