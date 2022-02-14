package com.ganzhenghao.springbootmongodbstudy;

import com.ganzhenghao.springbootmongodbstudy.pojo.Address;
import com.ganzhenghao.springbootmongodbstudy.pojo.Person;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@SpringBootTest
class SpringBootMongodbStudyApplicationTests {

    @Autowired
    private MongoTemplate mongo;

    @Test
    void contextLoads() {
    }


    @Test
    public void save() {
        mongo.save(new Person(ObjectId.get(), "张三", 23, new Address("四川省", "成都市", "000000")));
    }

    @Test
    public void selectPersonListByName() {
        Query query = Query.query(Criteria.where("name").is("张三"));
        List<Person> people = mongo.find(query, Person.class);
        people.forEach(System.out::println);
    }

    @Test
    public void selectByPage() {
        int page = 1;
        int size = 1;
        Query query = new Query().limit(size)
                .skip((page - 1) * size);
        mongo.find(query, Person.class).forEach(System.out::println);

    }

    @Test
    public void update() {
        Person person = new Person();
        person.setId(new ObjectId("60b8713c4eaff44e8e6dea81"));
        person.setAge(54);

        Query query = Query.query(Criteria.where("id").is(person.getId()));

        Update update = Update.update("age", person.getAge());

        UpdateResult updateResult = mongo.updateFirst(query, update, Person.class);

        System.out.println("updateResult = " + updateResult);

    }

    @Test
    public void deleteById() {
        Query query = Query.query(Criteria.where("id").is("60b8713c4eaff44e8e6dea81"));
        DeleteResult deleteResult = mongo.remove(query, Person.class);
        System.out.println("deleteResult = " + deleteResult);

    }
    

}
