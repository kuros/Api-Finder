package test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("sample")
public class SimpleController {

    @RequestMapping(value = "/no-param", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public void noParam(){
    }

    @RequestMapping(method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public void defaultMapping(){
    }

    @RequestMapping(value ={"/a", "/b"}, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
    @ResponseStatus(HttpStatus.OK)
    public void multipleRequestType(){
    }
}
