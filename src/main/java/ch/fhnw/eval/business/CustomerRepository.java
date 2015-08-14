package ch.fhnw.eval.business;

import ch.fhnw.eval.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
