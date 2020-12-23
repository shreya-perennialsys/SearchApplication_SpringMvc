package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class RegisterDao {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public void addPeople(Register register){
        hibernateTemplate.saveOrUpdate(register);
    }

    @Transactional
    public void deletePeople(long id){
        Register register=hibernateTemplate.load(Register.class,id);
        hibernateTemplate.delete(register);

    }
}

