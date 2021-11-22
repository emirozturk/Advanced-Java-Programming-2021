package com.emirozturk.Bildirim.DAO;

import com.emirozturk.Bildirim.Entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
}
