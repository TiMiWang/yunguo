//package com.yunguo.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.yunguo.domain.Line;
//
//import java.util.List;
//
//@Repository
//public interface LineRepository extends JpaRepository<Line, Integer> {
//
//    Page<Line> findAll(Specification<Line> spec, Pageable pageable);
//
//    List<Line> findByLineName(String lineName);
//
//    @Query(value = "select id from t_resource where name like ?1 limit 1;",nativeQuery = true)
//    Integer getResourceIdByName(String unionLineName);
//
//    List<Line> findLineByLineName(String lineName);
//}
