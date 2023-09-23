package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.MedicineEntity;

import jakarta.transaction.Transactional;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Integer> {

	

@Query(value = "select * from medicine_entity where medicinename =:m",nativeQuery = true)
public List<MedicineEntity> getnameInfo(@Param("m") String name);
@Modifying
@Transactional
@Query(value = "delete from medicine_entity  where medicineid=:f",nativeQuery = true)
public Integer deletecustomerId(@Param("f") int medicineid);


@Modifying
@Transactional
@Query(value = "update medicine_entity  set medicineid=?1 where medicineid=?2",nativeQuery = true)

public int updatecustomerId(int newid,int oldid);
}
