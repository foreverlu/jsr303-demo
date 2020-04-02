package cn.eversec.jsr303_demo;

import cn.eversec.jsr303_demo.bean.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.validation.Valid;

@RestController
public class JSR303Controller {

    @RequestMapping("/to_login")
    public String jsrToLogin(){
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String login(@Valid User user, HttpResponse response, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            List<String> mesList = new ArrayList<>();
            for(ObjectError err : errorList){
                mesList.add(err.getDefaultMessage());
                FieldError fe = (FieldError)err;
                System.out.println(err.getDefaultMessage());
            }
            return mesList.get(0);
        }
       // System.out.println(name+":"+pwd+","+phone);

        String token = UUID.randomUUID().toString().replace("-","");
        Cookie cookie = new Cookie("token",token);


        return user.getName()+":"+user.getPhone()+";"+user.getPwd();
    }

    @GetMapping("/test")
    public String test(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime localDateTime){

        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }



}
