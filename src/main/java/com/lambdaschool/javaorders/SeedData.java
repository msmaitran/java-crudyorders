package com.lambdaschool.javaorders;

import com.lambdaschool.javaorders.models.Agents;
import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.models.Orders;
import com.lambdaschool.javaorders.models.Payments;
import com.lambdaschool.javaorders.repositories.AgentRepository;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import com.lambdaschool.javaorders.repositories.OrderRepository;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    private CustomerRepository customerrepo;

    @Autowired
    private AgentRepository agentrepo;

    @Autowired
    private OrderRepository ordersrepo;

    @Autowired
    private PaymentRepository paymentrepo;

    @Override
    public void run(String[] args) throws Exception
    {
        Payments pay1 = new Payments("Cash");
        Payments pay2 = new Payments("Gift Card");
        Payments pay3 = new Payments("Credit Card");
        Payments pay4 = new Payments("Mobile Pay");

        pay1 = paymentrepo.save(pay1);
        pay2 = paymentrepo.save(pay2);
        pay3 = paymentrepo.save(pay3);
        pay4 = paymentrepo.save(pay4);

        Agents a01 = new Agents("Ramasundar", "Bangalore", 0.15, "077-25814763", "");
        Agents a02 = new Agents("Alex", "London", 0.13, "075-12458969", "");
        Agents a03 = new Agents("Alford", "New York", 0.12, "044-25874365", "");
        Agents a04 = new Agents("Ravi", "Bangalore", 0.15, "077-45625874", "");
        Agents a05 = new Agents("Santakumar", "Chennai", 0.14, "007-22388644", "");
        Agents a06 = new Agents("Lucida", "San Jose", 0.12, "044-52981425", "");
        Agents a07 = new Agents("Anderson", "Brisban", 0.13, "045-21447739", "");
        Agents a08 = new Agents("Subbarao", "Bangalore", 0.14, "077-12346674", "");
        Agents a09 = new Agents("Mukesh", "Mumbai", 0.11, "029-12358964", "");
        Agents a10 = new Agents("McDen", "London", 0.15, "078-22255588", "");
        Agents a11 = new Agents("Ivan", "Torento", 0.15, "008-22544166", "");
        Agents a12 = new Agents("Benjamin", "Hampshair", 0.11, "008-22536178", "");

        Customers c01 = new Customers("Holmes", "London", "London", "UK", "2", 6000.00, 5000.00, 7000.00, 4000.00, "BBBBBBB", a03);
        Customers c02 = new Customers("Micheal", "New York", "New York", "USA", "2", 3000.00, 5000.00, 2000.00, 6000.00, "CCCCCCC", a08);
        Customers c03 = new Customers("Albert", "New York", "New York", "USA", "3", 5000.00, 7000.00, 6000.00, 6000.00, "BBBBSBB", a08);
        Customers c04 = new Customers("Ravindran", "Bangalore", "Bangalore", "India", "2", 5000.00, 7000.00, 4000.00, 8000.00, "AVAVAVA", a11);
        Customers c05 = new Customers("Cook", "London", "London", "UK", "2", 4000.00, 9000.00, 7000.00, 6000.00, "FSDDSDF", a06);
        Customers c06 = new Customers("Stuart", "London", "London", "UK", "1", 6000.00, 8000.00, 3000.00, 11000.00, "GFSGERS", a03);
        Customers c07 = new Customers("Bolt", "New York", "New York", "USA", "3", 5000.00, 7000.00, 9000.00, 3000.00, "DDNRDRH", a08);
        Customers c08 = new Customers("Fleming", "Brisban", "Brisban", "Australia", "2", 7000.00, 7000.00, 9000.00, 5000.00, "NHBGVFC", a05);
        Customers c09 = new Customers("Jacks", "Brisban", "Brisban", "Australia", "1", 7000.00, 7000.00, 7000.00, 7000.00, "WERTGDF", a05);
        Customers c10 = new Customers("Yearannaidu", "Chennai", "Chennai", "India", "1", 8000.00, 7000.00, 7000.00, 8000.00, "ZZZZBFV", a10);
        Customers c11 = new Customers("Sasikant", "Mumbai", "Mumbai", "India", "1", 7000.00, 11000.00, 7000.00, 11000.00, "147-25896312", a02);
        Customers c12 = new Customers("Ramanathan", "Chennai", "Chennai", "India", "1", 7000.00, 11000.00, 9000.00, 9000.00, "GHRDWSD", a10);
        Customers c13 = new Customers("Avinash", "Mumbai", "Mumbai", "India", "2", 7000.00, 11000.00, 9000.00, 9000.00, "113-12345678", a02);
        Customers c14 = new Customers("Winston", "Brisban", "Brisban", "Australia", "1", 5000.00, 8000.00, 7000.00, 6000.00, "AAAAAAA", a05);
        Customers c15 = new Customers("Karl", "London", "London", "UK", "0", 4000.00, 6000.00, 7000.00, 3000.00, "AAAABAA", a06);
        Customers c16 = new Customers("Shilton", "Torento", "Torento", "Canada", "1", 10000.00, 7000.00, 6000.00, 11000.00, "DDDDDDD", a04);
        Customers c17 = new Customers("Charles", "Hampshair", "Hampshair", "UK", "3", 6000.00, 4000.00, 5000.00, 5000.00, "MMMMMMM", a09);
        Customers c18 = new Customers("Srinivas", "Bangalore", "Bangalore", "India", "2", 8000.00, 4000.00, 3000.00, 9000.00, "AAAAAAB", a07);
        Customers c19 = new Customers("Steven", "San Jose", "San Jose", "USA", "1", 5000.00, 7000.00, 9000.00, 3000.00, "KRFYGJK", a10);
        Customers c20 = new Customers("Karolina", "Torento", "Torento", "Canada", "1", 7000.00, 7000.00, 9000.00, 5000.00, "HJKORED", a04);
        Customers c21 = new Customers("Martin", "Torento", "Torento", "Canada", "2", 8000.00, 7000.00, 7000.00, 8000.00, "MJYURFD", a04);
        Customers c22 = new Customers("Ramesh", "Mumbai", "Mumbai", "India", "3", 8000.00, 7000.00, 3000.00, 12000.00, "Phone No", a02);
        Customers c23 = new Customers("Rangarappa", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "AAAATGF", a01);
        Customers c24 = new Customers("Venkatpati", "Bangalore", "Bangalore", "India", "2", 8000.00, 11000.00, 7000.00, 12000.00, "JRTVFDD", a07);
        Customers c25 = new Customers("Sundariya", "Chennai", "Chennai", "India", "3", 7000.00, 11000.00, 7000.00, 11000.00, "PPHGRTS", a10);

        Orders o01 = new Orders(1000.00, 600.00, c13, "SOD");
        o01.addPayments(pay1);

        Orders o02 = new Orders(3000.00, 500.00, c19, "SOD");
        o02.addPayments(pay2);

        Orders o03 = new Orders(4500.00, 900.00, c07, "SOD");
        o03.addPayments(pay3);
        o03.addPayments(pay2);

        Orders o04 = new Orders(2000.00, 0.00, c16, "SOD");
        o04.addPayments(pay4);

        Orders o05 = new Orders(4000.00, 600.00, c22, "SOD");
        o05.addPayments(pay2);

        Orders o06 = new Orders(2000.00, 0.00, c12, "SOD");
        o06.addPayments(pay3);

        Orders o07 = new Orders(3500.00, 2000.00, c02, "SOD");
        o07.addPayments(pay4);

        Orders o08 = new Orders(2500.00, 400.00, c03, "SOD");
        o08.addPayments(pay1);

        Orders o09 = new Orders(500.00, 0.00, c23, "SOD");
        o09.addPayments(pay3);

        Orders o10 = new Orders(4000.00, 700.00, c07, "SOD");
        o10.addPayments(pay4);

        Orders o11 = new Orders(1500.00, 600.00, c08, "SOD");
        o11.addPayments(pay2);

        Orders o12 = new Orders(2500.00, 0.00, c25, "SOD");
        o12.addPayments(pay1);

        agentrepo.save(a01);
        agentrepo.save(a02);
        agentrepo.save(a03);
        agentrepo.save(a04);
        agentrepo.save(a05);
        agentrepo.save(a06);
        agentrepo.save(a07);
        agentrepo.save(a08);
        agentrepo.save(a09);
        agentrepo.save(a10);
        agentrepo.save(a11);
        agentrepo.save(a12);

        customerrepo.save(c01);
        customerrepo.save(c02);
        customerrepo.save(c03);
        customerrepo.save(c04);
        customerrepo.save(c05);
        customerrepo.save(c06);
        customerrepo.save(c07);
        customerrepo.save(c08);
        customerrepo.save(c09);
        customerrepo.save(c10);
        customerrepo.save(c11);
        customerrepo.save(c12);
        customerrepo.save(c13);
        customerrepo.save(c14);
        customerrepo.save(c15);
        customerrepo.save(c16);
        customerrepo.save(c17);
        customerrepo.save(c18);
        customerrepo.save(c19);
        customerrepo.save(c20);
        customerrepo.save(c21);
        customerrepo.save(c22);
        customerrepo.save(c23);
        customerrepo.save(c24);
        customerrepo.save(c25);

        ordersrepo.save(o01);
        ordersrepo.save(o02);
        ordersrepo.save(o03);
        ordersrepo.save(o04);
        ordersrepo.save(o05);
        ordersrepo.save(o06);
        ordersrepo.save(o07);
        ordersrepo.save(o08);
        ordersrepo.save(o09);
        ordersrepo.save(o10);
        ordersrepo.save(o11);
        ordersrepo.save(o12);
    }
}