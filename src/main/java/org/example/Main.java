package org.example;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    static void main() {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("===Find seller by Id===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);


    }
}
