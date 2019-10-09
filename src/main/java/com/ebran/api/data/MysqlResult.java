package com.ebran.api.data;

import com.ebran.api.connection.MysqlConnection;
import com.ebran.api.model.Department;
import com.ebran.api.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MysqlResult {

    private Connection connection;

    public MysqlResult() {
        try {
            this.connection = MysqlConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> list = new ArrayList<>();

        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from employee");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Employee employee = new Employee();

                int id = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String address = result.getString(4);
                int deptId = result.getInt(5);
                String hobbiesData = result.getString(6);

                ArrayList<String> hobbies = new ArrayList<>(Arrays.asList(hobbiesData.split(",")));

                employee.setId(id);
                employee.setName(name);
                employee.setEmail(email);
                employee.setAddress(address);
                employee.setHobbies(hobbies);

                PreparedStatement deptStatement = this.connection.prepareStatement("select * from department where deptId = ?");
                deptStatement.setInt(1, deptId);
                ResultSet deptResult = deptStatement.executeQuery();

                if (deptResult.next()) {
                    String deptName = deptResult.getString(2);
                    Department department = new Department(deptId, deptName);
                    employee.setDepartment(department);
                }

                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Employee getSingleEmployee(int id) {

        Employee employee = new Employee();

        try {
            PreparedStatement statement = this.connection.prepareStatement("select * from employee where id = " + id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setEmail(resultSet.getString(3));
                employee.setAddress(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }


}
