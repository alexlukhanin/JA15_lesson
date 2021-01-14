package org.alex.one_to_one;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.Date;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

       // Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setName("Vitalii3");
        customer.setEmail("someMail3@gmail.com");

        FinancialOperation operation = new FinancialOperation();
        operation.setDate(new Date());
        operation.setTotal(2050);
        customer.setFinancialOperation(operation);

        // save to DB
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();

        // read from DB
        Customer c = (Customer) session.get(Customer.class, 1);
        System.out.println(c + "--->" + c.getFinancialOperation());

        FinancialOperation financeOperation = (FinancialOperation) session.get(FinancialOperation.class, 2);
        System.out.println(financeOperation + "--->" + financeOperation.getCustomer());


       // transaction.commit();


    }
}
