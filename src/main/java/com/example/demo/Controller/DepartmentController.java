package com.example.demo.Controller;

import com.example.demo.Dto.RequestDepartment;
import com.example.demo.Dto.ResponseDepartement;
import com.example.demo.Service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/example/department")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("")
    public ResponseEntity<List<ResponseDepartement>> getAllDepartment(){
        List<ResponseDepartement>departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);

    }
    @PostMapping("")
    public ResponseEntity<Object>addDepartment(@RequestBody @Valid RequestDepartment request){
        departmentService.createDepartment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseDepartement>getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
@PutMapping(value="{id}")
    public ResponseEntity<Object>updateDepartment(
            @PathVariable(name="id")Long id,
            @RequestBody @Valid RequestDepartment request ){
        departmentService.updateDepartment(id,request);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success!!!")
        );
}
@DeleteMapping(value = "{id}")
    public ResponseEntity<Object>deleteDepartment(@PathVariable Long id){
        boolean deleteDepartment= departmentService.deleteDepartment(id);
        if(deleteDepartment){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message","delete succes!!")

            );
        } return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Collections.singletonMap("message","department not exist")
    );
}
    @GetMapping("{id}/user")//lezm tbdl l path khtr aandk get kbal
    public ResponseEntity<ResponseDepartement>getDepartmentByIdd(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentByIdWithUser(id));
    }
}
