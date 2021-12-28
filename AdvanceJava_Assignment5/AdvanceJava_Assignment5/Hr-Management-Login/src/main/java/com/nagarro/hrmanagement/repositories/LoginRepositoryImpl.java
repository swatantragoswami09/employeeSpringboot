package com.nagarro.hrmanagement.repositories;

import com.nagarro.hrmanagement.model.User;
//import com.nagarro.model.User;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    @Autowired
    private EntityManager entityManager;
    
    

    @Override
    public User validateUser(User user){
        String username = user.getUserName();
        String password = user.getPassword();
        System.out.println(username+" : "+ password);
        
		
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM assignment5_users u WHERE u.username='"+username+"' AND u.password='"+password+"'",User.class);
        User result = query.getSingleResult();
        System.out.println(result);
        if(result!=null){
            return result;
        }
        return null;
    }
}
