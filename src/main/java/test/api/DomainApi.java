package test.api;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.Operation;
import test.domain.Domain;

@RepositoryRestController
@ResponseBody
public class DomainApi {

    @Operation
    @GetMapping("/domains/test")
    public Domain test() {
        return new Domain();
    }

}
