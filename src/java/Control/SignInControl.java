/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */
@Controller
public class SignInControl {
    @RequestMapping("/dang-nhap")
    public String signIn(){
        return "SignIn";
    }
    @RequestMapping(value="/dang-nhap",method=RequestMethod.POST)
     public String signInResult(@RequestParam("userName") String name,@RequestParam("password") String pass){
         if(name.equalsIgnoreCase("datnqhe141546")&&pass.equalsIgnoreCase("899168")){
             return "redirect:/home";//redirect để trở về đường dẫn có URL="home"
         }
        return "SignIn";
    }
}
