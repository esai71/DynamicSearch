package in.sai.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.sai.entity.PalnInsuranceEntity;

@Repository
public interface PlanRepository extends JpaRepository<PalnInsuranceEntity, Integer> {
    @Query("select distinct planName from PalnInsuranceEntity")
	public List<String> getAllPalnName();
    
    @Query("select distinct status from PalnInsuranceEntity")
   	public List<String> getAllStatus();
	
}
