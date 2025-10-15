package org.example;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    static void main() {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("===TEST 1: Find seller by Id===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("===TEST 2: Find seller by Department===");
        Department department = new Department(2, null);
        List<Seller> list =  sellerDao.findByDepartment(department);

        for (Seller obj: list ){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("===TEST 3: Find seller findAll===");
        list =  sellerDao.findAll();

        for (Seller obj: list ){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("===TEST 4:Insert new Seller===");
        Seller newSeller = new Seller(null, "NeymarJr", "neymar@gmail.com", new Date(), 45000.5, department);
        sellerDao.insert(newSeller);

        System.out.println("New seller inserted! new id = " + newSeller.getId());

    }
}
