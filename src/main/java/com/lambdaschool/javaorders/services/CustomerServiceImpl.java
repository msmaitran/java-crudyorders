package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agents;
import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.models.Orders;
import com.lambdaschool.javaorders.models.Payments;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerrepo;

    @Autowired
    private AgentService agentService;

    private PaymentService paymentService;

    @Override
    public List<Customers> findAllCustomers() {
        List<Customers> list = new ArrayList<>();
        customerrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerById(long id) {
        return customerrepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Customers> findCustomerByNameLike(String thename) {
        return customerrepo.findByCustnameContainingIgnoringCase(thename);
    }

    @Transactional
    @Override
    public Customers save(Customers customers) {
        Customers newCustomer = new Customers();

        newCustomer.setCustname(customers.getCustname());
        newCustomer.setCustcity(customers.getCustcity());
        newCustomer.setWorkingarea(customers.getWorkingarea());
        newCustomer.setCustcountry(customers.getCustcountry());
        newCustomer.setGrade(customers.getGrade());
        newCustomer.setOpeningamt(customers.getOpeningamt());
        newCustomer.setReceiveamt(customers.getReceiveamt());
        newCustomer.setPaymentamt(customers.getPaymentamt());
        newCustomer.setOutstandingamt(customers.getOutstandingamt());
        newCustomer.setPhone(customers.getPhone());
        newCustomer.setAgents(customers.getAgents());

        if (agentService.findAgentById(customers.getAgents().getAgentcode()) != null) {
            Agents agents = agentService.findAgentById(customers.getAgents().getAgentcode());
            newCustomer.setAgents(agents);
        }

        List<Orders> newCustomerOrders = customers.getOrders();
        List<Payments> newOrderPayments = new ArrayList<>();
        for (Orders o : newCustomerOrders) {
            o.setCustomers(newCustomer);
            for (Payments p : o.getPayments()) {
                Payments payments = paymentService.findPaymentById(p.getPaymentid());
                newOrderPayments.add(payments);
            }
            for (Payments p : newOrderPayments) {
                o.addPayments(p);
            }
        }
        newCustomer.setOrders(newCustomerOrders);
        return customerrepo.save(newCustomer);
    }

    @Transactional
    @Override
    public Customers update(Customers customers, long custcode) {

        Customers currentCustomer = findCustomerById(custcode);

        if (customers.getCustname() != null) {
            currentCustomer.setCustname(customers.getCustname());
        }

        if (customers.getCustcity() != null) {
            currentCustomer.setCustcity(customers.getCustcity());
        }

        if (customers.getWorkingarea() != null) {
            currentCustomer.setWorkingarea(customers.getWorkingarea());
        }

        if (customers.getCustcountry() != null) {
            currentCustomer.setCustcountry(customers.getCustcountry());
        }

        if (customers.getGrade() != null) {
            currentCustomer.setGrade(customers.getGrade());
        }

        if (customers.hasopeningamt) {
            currentCustomer.setOpeningamt(customers.getOpeningamt());
        }

        if (customers.hasreceiveamt) {
            currentCustomer.setReceiveamt(customers.getReceiveamt());
        }

        if (customers.haspaymentamt) {
            currentCustomer.setPaymentamt(customers.getPaymentamt());
        }

        if (customers.hasoutstandingamt) {
            currentCustomer.setOutstandingamt(customers.getOutstandingamt());
        }

        if (customers.getPhone() != null) {
            customers.setPhone(customers.getPhone());
        }

        if (agentService.findAgentById(customers.getAgents().getAgentcode()) != null) {
            Agents agents = agentService.findAgentById(customers.getAgents().getAgentcode());
            currentCustomer.setAgents(agents);
        }

        return customerrepo.save(currentCustomer);
    }

    @Transactional
    @Override
    public void delete(long id) {
        if (findCustomerById(id) != null) {
            customerrepo.deleteById(id);
        }
    }
}
