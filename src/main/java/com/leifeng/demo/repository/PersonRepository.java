package com.leifeng.demo.repository;

import com.leifeng.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author leifeng
 * @Date 2017-10-23
 **/
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByName(String name);
    List<Person> findByAddress(String address);
    List<Person> findByNameAndAddress(String name,String address);
    @Query("select p from Person p where p.name = :name and p.address =:address")
    List<Person> withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
}
