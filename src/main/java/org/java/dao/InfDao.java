package org.java.dao;

import org.java.entity.Inf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class InfDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Inf f) {
        String sql = "insert into inf values(null,?,?)";

        jdbcTemplate.update(sql, f.getName(), f.getAge());
    }

    public List<Inf> findAll() {
        String sql = "select * from inf";
        BeanPropertyRowMapper<Inf> mapper = new BeanPropertyRowMapper<Inf>(Inf.class);

        return jdbcTemplate.query(sql, mapper);
    }

    public List<Map<String,Object>> findAllMap(){
        String sql = "select * from inf where name like ? and age between ? and ?";
        Object[] args={"%c%",20,30};
        return jdbcTemplate.queryForList(sql,args);
    }

    public void del(Integer id) {
        jdbcTemplate.update("delete from inf where id=?",id);
    }


    public void update(Inf f) {
        String sql = "update inf set name=?,age=? where id=?";
        jdbcTemplate.update(sql,f.getName(),f.getAge(),f.getId());
    }

    public Inf findById(Integer id) {
        String  sql = "select * from inf where id=?";
        Object[] args = {id};
        RowMapper<Inf> rowMapper = new BeanPropertyRowMapper<Inf>(Inf.class);
        return jdbcTemplate.queryForObject(sql ,args,rowMapper );
    }





    public Map<String, Object> findById2(Integer id) {
        String  sql = "select * from inf where id=?";
        Object[] args = {id};
        return jdbcTemplate.queryForMap(sql,id);
    }


    public List<Map<String, Object>> findAll2() {
        String sql = "select * from inf";
        return jdbcTemplate.queryForList(sql);
    }


    public List<Inf> findByCondition(Inf f) {
        String sql = "select * from inf where name like ? and age>?";
        Object[] args = {"%"+f.getName()+"%",f.getAge()};
        RowMapper<Inf> rowMapper = new BeanPropertyRowMapper<Inf>(Inf.class);
        return jdbcTemplate.query(sql,args,rowMapper );
    }

    public List<Inf> findPage(Integer start,Integer size) {
        String sql = "select * from inf limit ?,?";
        Object[] args= {start,size};
        RowMapper<Inf> rowMapper = new BeanPropertyRowMapper<Inf>(Inf.class);
        return jdbcTemplate.query(sql,args,rowMapper);
    }

}
