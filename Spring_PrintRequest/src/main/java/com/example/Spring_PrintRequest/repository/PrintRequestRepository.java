package com.example.Spring_PrintRequest.repository;

import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.printrequest.PrintRequestPrimarykey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface PrintRequestRepository extends JpaRepository<PrintRequest, PrintRequestPrimarykey>,CustomPrintRequestRepository {

    @Query(value = "SELECT p FROM PrintRequest p where p.id = :id" )
    PrintRequest findByReqId(@Param("id") PrintRequestPrimarykey id);

    @Query(value = "SELECT p FROM PrintRequest p where p.branchCode = ?1",
            countQuery = "SELECT count(p) FROM PrintRequest p where p.branchCode = ?1")
    Page<PrintRequest> findReqByReqPanPagination(String panNumber, Pageable pageable);

}
