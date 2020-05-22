package com.example.erp.mapper;

import com.example.erp.entity.DTO.DepartmentCountDTO;
import com.example.erp.entity.DTO.EmpAgeTempDTO;
import com.example.erp.entity.EmpRemove;
import com.example.erp.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> selectAll();

    List<Employee> selectByOptions(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long nextWorkId();

    void multiInsert(@Param("list") List<Employee> employees);

    List<Employee> getEmpWithSalary(@Param("keyword") String keyword);


    int findByEid(Integer eid);


    int insertToEmpSal(@Param("eid") Integer eid, @Param("sid") Integer sid);

    int updateEmpSal(@Param("eid") Integer eid,@Param("sid") Integer sid);

    Employee findByNameAndWorkId(@Param("name") String name,@Param("workId") String workId);

    Integer getIdByWorkId(@Param("workId") String workId);

    Employee getEmpByWorkId(@Param("workId") String workId);

    int updateDepAndPos(EmpRemove empRemove);

    Employee getEmployeeByWorkId(@Param("workId") String workId);

    List<Employee> selectByDepartmentId(@Param("departmentId") Integer departmentId);

    List<DepartmentCountDTO> getDepCount();

    List<EmpAgeTempDTO> getEmpAgeCount();

    int checkOldPass(@Param("eid") Integer eid,@Param("oldPass") String oldPass);

    int updatePassword(@Param("eid")Integer eid, @Param("newPass")String newPass);

    List<Employee> findByProjectId(Integer pid);
}