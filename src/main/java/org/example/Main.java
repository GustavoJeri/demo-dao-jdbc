package org.example;

import model.entities.Department;
import model.entities.Seller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    static void main() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Department obj =  new Department(1, "Books");
        Seller seller = new Seller(1, "João", "joao@gmail.com", new Date(), 1500.5, obj);

        System.out.println(seller);


    }
}
