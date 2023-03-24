package dans.multi.pro.brian.question_1.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dans.multi.pro.brian.question_1.entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer>{
	UserEntity findByUsername(String username);
}
