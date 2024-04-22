package com.example.TransactionalAnnotation.service;

import com.example.TransactionalAnnotation.dto.JoinDto;
import com.example.TransactionalAnnotation.model.Address;
import com.example.TransactionalAnnotation.model.Employee;
import com.example.TransactionalAnnotation.repository.EmpRepository;
import org.hibernate.query.Query;
import org.hibernate.transform.ToListResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.Alias;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    EntityManager entityManager;

    @Transactional
    public String addEmployeeToDb(Employee employee){
        if(Objects.nonNull(employee)) {
            Address address=new Address("GZbB",employee);
            employee.setAddress(address);
            empRepository.save(employee);
//            addressService.addAddress(new Address("Gb nagar",employee));

            return "create";
        }
        else {
            return "error";
        }
    }
//    @Transactional(isolation = Isolation.READ_COMMITTED)
    public String updateEmp(String id){
        Optional<Employee> byId = empRepository.findById(Long.valueOf(id));
        if (byId.isPresent()){
            Employee employee = byId.get();
            employee.setLastName("pppp");
//            empRepository.save(employee);
            return null;
        }
        else {
            return "not exit";
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public Employee getEmployee(String  id){
        Optional<Employee> byId = empRepository.findById(Long.valueOf(id));
        if(byId.isPresent())
            return byId.get();
        return null;
    }
    @Transactional
    public void removeEmp(String  id){

        empRepository.deleteById(Long.valueOf(id));
    }
    @Transactional
    public List<?> fetchEmployees(){
        //native query
//        String sqlQuery="SELECT * from employee";
//               return entityManager.createNativeQuery(sqlQuery)
//                       .unwrap(org.hibernate.query.Query.class)
//                       .setResultTransformer(ToListResultTransformer.INSTANCE)
//                       .getResultList();      //here @JsonIgnore which reference which create circular reference

        //named query
        List<?> resultList = entityManager.createNamedQuery("Emp.FindAll")
                .unwrap(Query.class)
                .setResultTransformer(ToListResultTransformer.INSTANCE)
                .getResultList();
        System.out.println(resultList);    //remove the  field which create circular reference in , to string()
        return resultList;
    }
    @Transactional
    public List<?> getJoinResult(){
        String query="select e.firstName as 'fullName',a.city as 'city'" +
                "from Employee e" +
                "join e.address a" ;
        return entityManager.createNativeQuery(query)
                .unwrap(Query.class)
                .setResultTransformer(Transformers.aliasToBean(JoinDto.class))
                .getResultList();
    }
}
