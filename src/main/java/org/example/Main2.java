package org.example;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static void main() {
        Scanner sc = new  Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println();
        System.out.println("==========TEST 1: FIND DEPARTMENT BY ID==========");
        Department department = departmentDao.findById(5);
        System.out.println(department);//returning null, see why later


        System.out.println();
        System.out.println("==========TEST 2: INSERT NEW DEPARTMENT==========");
        Department newDepartment = new Department(null, "Shoes");
        departmentDao.insert(newDepartment);
        System.out.println("Department inserted sucessfully! New id: " + newDepartment.getId());


        System.out.println();
        System.out.println("==========TEST 3: UPDATE DEPARTMENT==========");
        department = departmentDao.findById(7);
        department.setName("IT");
        departmentDao.update(department);
        System.out.println("Departmente updated sucessfully! New id: " + department.getId());

        System.out.println();
        System.out.println("==========TEST 4: DELETE DEPARTMENT BY ID==========");
        System.out.print("Enter a department id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletion completed sucessfully!");

        System.out.println("==========TEST 5: FIND ALL DEPARTMENTS==========");
        List<Department> list = departmentDao.findAll();

        for(Department d : list){
            System.out.println(d);
        }


    }
}
