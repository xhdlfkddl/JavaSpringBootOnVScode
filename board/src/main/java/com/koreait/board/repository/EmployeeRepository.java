package com.koreait.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koreait.board.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> { //= <entity 클래스 명, PK의 데이터타입>
    
    // 해당 메서드를 실행시키면 JpaRepository가 알아서 Database에 접근하여 결과를 반환함
    public boolean existsByTelNumber(String telNumber);
    //
    public boolean existsByDepartment(String department);
    //
    public EmployeeEntity findByEmployeeNumber(int employeeNumber);
    
    // todo: 수정해야함
    // public boolean existsByDepartment(int cheif);
}
