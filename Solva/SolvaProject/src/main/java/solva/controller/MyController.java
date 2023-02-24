package solva.controller;

import com.google.protobuf.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import solva.dao.UserDao;
import solva.entity.All_transactions;
import solva.entity.Users;
import solva.service.TransactionService;
import solva.service.UserService;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUsers(Model model){
        List<Users> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping("/userInfo")
    public String userInfo(@RequestParam("userId") int id, Model model){
        Users user = userService.getUser(id);
        All_transactions transaction = new All_transactions();
        transaction.setUser_id(id);
        model.addAttribute("currentUser", user);
        model.addAttribute("transactions", transaction);
        return "user-info";
    }

    @RequestMapping("/setTransaction")
    public String setTransaction(@ModelAttribute("currentUser") Users user){
        int id = user.getId();
        double transactionLimit = user.getTransaction_limit();
        userService.setTransaction(id, transactionLimit);
        transactionService.setTransaction(id, transactionLimit);
        return "redirect:/userInfo?userId=" + id;
    }

    @PostMapping("/setPayment")
    public String setPayment(@ModelAttribute("all_transactions")All_transactions transactions){
        double payment = transactions.getPayment();
        int id = transactions.getUser_id();
        if(transactionService.payment(id, payment) == 1){
            return "redirect:/userInfo?error=error&userId=" + id;
        }
        userService.payment(id, payment);
        return "redirect:/userInfo?userId=" + id;
    }

}
