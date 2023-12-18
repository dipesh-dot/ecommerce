package com.addressservice.repository;



import com.addressservice.entity.DeliveryAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<DeliveryAddresses,Long> {
}
