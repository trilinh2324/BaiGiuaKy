package com.example.baitap.repository;

import com.example.baitap.model.PerSon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPerSonRepository extends PagingAndSortingRepository<PerSon ,Integer > {

}
