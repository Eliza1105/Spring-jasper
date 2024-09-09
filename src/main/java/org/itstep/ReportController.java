package org.itstep;

import net.sf.jasperreports.engine.JRException;
import org.itstep.customer.Customer;
import org.itstep.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    private CustomerService customerService;
    @Autowired
private ReportService reportService;
    @GetMapping(value={"/","","index"})
    public String index(){
        return "redirect:/index.html";
    }

    @GetMapping(value="/customers/report")
    public String generateReport(){
        List<Customer> customers = customerService.findAll();
        try {
            reportService.exportReport(customers, "customers2.jrxml", "customers.html", "html");
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
return  "redirect:/customers.html";
    }
}
