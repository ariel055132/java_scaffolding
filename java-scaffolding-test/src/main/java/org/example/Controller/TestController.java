package org.example.Controller;

import com.test.common.bean.Result;
import org.example.Entity.People;
import org.example.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {
    @Autowired
    private TestService testService;

    @ResponseBody
    @PostMapping("/test")
    public Result test(@RequestBody @Validated People rq) {
        return testService.testPeople(rq);
    }
}
