package org.example.Service;

import com.test.common.bean.Result;
import com.test.common.bean.ServiceRq;
import com.test.common.bean.ServiceRs;
import com.test.common.bean.ServiceRsBuilder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.example.Controller.Bean.TestRq;
import org.example.Entity.People;
import org.example.Service.Bean.TestRs;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public ServiceRs<TestRs> test(@NotNull @Valid ServiceRq<TestRq> request) {
        TestRq rq = request.getContent();
        TestRs rs = new TestRs();
        rs.setMsg(rq.getForeignerId());
        return ServiceRsBuilder.success(rs);
    }

    public Result testPeople(@NotNull @Valid People rq) {
        System.out.println(rq.getPwd());
        return Result.successResult();
    }
}
