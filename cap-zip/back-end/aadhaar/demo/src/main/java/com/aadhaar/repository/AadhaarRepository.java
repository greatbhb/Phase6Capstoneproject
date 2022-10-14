package com.aadhaar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aadhaar.bean.AadhaarInfo;

@Repository
public interface AadhaarRepository extends JpaRepository<AadhaarInfo, String>{

	@Query("select a from AadhaarInfo a where a.status= :pending ")
	public List<AadhaarInfo> allRequest(@Param("pending") String status);


}
