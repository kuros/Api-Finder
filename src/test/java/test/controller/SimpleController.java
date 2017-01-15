package test.controller;

import com.sun.istack.internal.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("sample")
public class SimpleController {

//    @RequestMapping(value = "/no-param", method = {RequestMethod.GET})
//    @ResponseStatus(HttpStatus.OK)
//    public void noParam(){
//    }
//
//    @RequestMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public void defaultMapping(){
//    }
//
//    @RequestMapping(value ={"/a", "/b"}, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
//    @ResponseStatus(HttpStatus.OK)
//    public void multipleRequestType(){
//    }

    @RequestMapping(value = "/with-single-param", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public void withRequestParam(@RequestParam @NotNull String Key){
    }

    @RequestMapping(value = "/with-single-param-value", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public void withRequestParamValue(@RequestParam("id") @NotNull String Key){
    }

    @RequestMapping(value = "/with-simple-body", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public void withRequestBodySimpleType(@RequestBody final String body){

    }

    @RequestMapping(value = "/with-complex-body", method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public void withRequestBodyComplexType(@RequestBody final ComplexRequestBody body){

    }
}
