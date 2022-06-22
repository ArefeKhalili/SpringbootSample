package com.example.Spring_PrintRequest.repository;

import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public class PrintRequestJDBCTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public int insertPrintRequest(PrintRequest printRequest){
        String sql =
        "INSERT INTO T_PrintRequest (id,\n" +
                "    c_cardPAN,\n" +
                "c_personnelCode,\n" +
                "c_branchCode,\n" +
                "c_ipAddress) VALUES (?,?,?,?)";
       return jdbcTemplate.update(sql,new Object[]{printRequest.getId(),printRequest.getCardPAN(),
               printRequest.getPersonnelCode(),printRequest.getBranchCode(),printRequest.getIpAddress()});
    }
    public int[] batchInsertIntoPrintReqTableWithNamedParameter(List<PrintRequest> cardList){
        String sqlInsertQuery = "INSERT INTO t_print_request VALUES (:branchCode, :ipAddress, :cardPAN," +
                ":branchCode,:personnelCode,:ipAddress)";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(cardList.toArray());
        return namedParameterJdbcTemplate.batchUpdate(sqlInsertQuery,batch);
    }
}
