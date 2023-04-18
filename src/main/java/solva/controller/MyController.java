package solva.controller;

import com.google.protobuf.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    public String sign(){
        return "sign";
    }

//    @RequestMapping("/example")
//    public String showAllUsers(Model model){
//        List<Users> allUsers = userService.getAllUsers();
//        model.addAttribute("allUsers", allUsers);
//        return "all-users";
//    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("pwd") String password, Model model){

        int id = userService.checkPass(password);

        if(id != 0){
//            List<Users> allUsers = userService.getAllUsers();
//            model.addAttribute("allUsers", allUsers);
//           return "all-users";
            Users user = userService.getUser(id);
            All_transactions transaction = new All_transactions();
            transaction.setUser_id(id);
            model.addAttribute("currentUser", user);
            model.addAttribute("transactions", transaction);
            return "user-info";
        }
        return "sign";
    }

    @RequestMapping("/setTransaction")
    public String setTransaction(@ModelAttribute("currentUser") Users user, Model model){
        int id = user.getId();
        double transactionLimit = user.getTransaction_limit();
        userService.setTransaction(id, transactionLimit);
        transactionService.setTransaction(id, transactionLimit);
        Users user1 = userService.getUser(id);
        All_transactions transactions = new All_transactions();
        transactions.setUser_id(id);
        model.addAttribute("currentUser", user1);
        model.addAttribute("transactions", transactions);
        return "user-info";
    }

    @RequestMapping("/setPayment")
    public String setPayment(@ModelAttribute("all_transactions")All_transactions transactions, Model model){
        double payment = transactions.getPayment();
        int id = transactions.getUser_id();
        String s = "";
        int i = transactionService.payment(id, payment);
        if(i == 1){
            s = "Error!";
        }
        else {
            s = "Well done!";
            userService.payment(id, payment);
        }
        Users user = userService.getUser(id);
        All_transactions transaction = new All_transactions();
        transaction.setUser_id(id);
        model.addAttribute("message", s);
        model.addAttribute("currentUser", user);
        model.addAttribute("transactions", transaction);
        return "user-info";
    }

}
