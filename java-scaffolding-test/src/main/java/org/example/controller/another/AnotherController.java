package org.example.controller.another;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/another")
@Tag(name = "Another", description = "Another API")
public class AnotherController {
    @GetMapping("/get")
    public String getAnother() {
        return "Another details";
    }
}
