package hr.ocenaokresowa.repository;

import hr.ocenaokresowa.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // wartość z search = %value%
    List<Contact> findAllByEmailLikeOrMessageLikeOrNameLikeOrPhoneLike(String email, String message, String name, String phone);
}
