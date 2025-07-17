package in.adarsh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.adarsh.Entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

	public CustomerEntity findByEmail(String email);

}
