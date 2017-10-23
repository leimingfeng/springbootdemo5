package com.leifeng.demo.controller;

import com.leifeng.demo.domain.Person;
import com.leifeng.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leifeng
 * @Date 2017-10-23
 **/
@RestController
public class DataController {
    protected static Logger logger = LoggerFactory.getLogger(DataController.class);
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/save")
    public Person save(String name,Integer age,String address){
        Person p = personRepository.save(new Person(null,name,age,address));
        return p;
    }

    @RequestMapping("/queryByAddress")
    public List<Person> queryByAddress(String address){
        logger.debug("queryByAddress 开始");
        logger.debug("queryByAddress 接收参数address={}",address);
        List<Person> personList = personRepository.findByAddress(address);
        return personList;
    }

    @RequestMapping("/queryByNameAndAddress")
    public List<Person> queryByNameAndAddress(String name,String address){
        logger.debug("queryByNameAndAddress 开始");
        logger.debug("queryByNameAndAddress 接收参数name={},address={}",name,address);
        List<Person> personList = personRepository.findByNameAndAddress(name,address);
        return personList;
    }

    @RequestMapping("/withByNameAndAddress")
    public List<Person> withByNameAndAddress(String name,String address){
        logger.debug("withByNameAndAddress 开始");
        logger.debug("withByNameAndAddress 接收参数name={},address={}",name,address);
        List<Person> personList = personRepository.withNameAndAddressQuery(name,address);
        return personList;
    }

    @RequestMapping("/findAll")
    public List<Person> findAll(){
        logger.debug("findAll start");
        List<Person> personList = personRepository.findAll(new Sort(Sort.Direction.DESC, "age"));
        return personList;
    }

    /**
     * 使用Page对象shixiang
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/page")
    public Page<Person> page(Integer currentPage,Integer pageSize){
        logger.debug("分页开始");
        Page<Person> personPage = personRepository.findAll(new PageRequest(currentPage, pageSize));
        return personPage;
    }
}
