package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.entity.Purchase;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.PurchaseService;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/MyCabinet", method = RequestMethod.GET)
    public String userCabinet(){
        return "userCabinet";
    }

    @RequestMapping(value = "/allMyPurchases", method = RequestMethod.GET)
    public String allUserPurchases(Principal principal, Model model) {
        List<Purchase> purchaseList = purchaseService.findAllUserPurchase(principal.getName());
        model.addAttribute("allPurchases", purchaseList);
        return "allUserPurchases";
    }

    @RequestMapping(value = "/personal-information", method = RequestMethod.GET)
    public String openMyPersonalData(Principal principal, Model model){
        User user = userService.findByLogin(principal.getName());
        model.addAttribute("thisUser", user);
        return "personalInformation";
    }

    @RequestMapping(value = "/personal-information/edit", method = RequestMethod.GET)
    public String openEditMyInformation(Principal principal, Model model){
        User user = userService.findByLogin(principal.getName());
        model.addAttribute("user", user);
        return "editMyInfo";
    }

    @RequestMapping(value = "/saveMyInfo", method = RequestMethod.POST)
    public String editUser(@RequestParam("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("secondName") String secondName,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("phone") String phone,
                           @RequestParam("homeAdress") String adr) {
        userService.edit(id, name, secondName, email, password, phone, adr);
        return "redirect:/personal-information";
    }
}
