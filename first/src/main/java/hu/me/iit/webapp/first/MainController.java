package hu.me.iit.webapp.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.PageAttributes.MediaType;

@Controller
public class MainController {
    @RequestMapping()
    @ResponseBody
    ResponseDto gyoker (){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setId(123);
        responseDto.setMessage("Hello");
        return responseDto;
    }
}
