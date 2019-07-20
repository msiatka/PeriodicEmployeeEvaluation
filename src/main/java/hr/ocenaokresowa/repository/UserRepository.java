package hr.ocenaokresowa.repository;

import hr.ocenaokresowa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getByEmail(String email);
//    User getByEmployeeId(int employeeid);
}
