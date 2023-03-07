package com.koreait.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.board.common.constant.ResponseMessage;
import com.koreait.board.dto.request.humanResource.PostHumanResourceRequestDto;
import com.koreait.board.dto.response.ResponseDto;
import com.koreait.board.dto.response.humanResource.GetHumanResourceResponseDto;
import com.koreait.board.dto.response.humanResource.PostHumanResourceResponseDto;
import com.koreait.board.entity.EmployeeEntity;
import com.koreait.board.repository.DepartmentRepository;
import com.koreait.board.repository.EmployeeRepository;

// ResponseMessage. ... 하지않고 static을 import하여 사용할 수도 있음
// import static com.koreait.board.common.constant.ResponseMessage.NOT_EXIST_DEPARTMENT_CODE;

@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(PostHumanResourceRequestDto dto) {

        PostHumanResourceResponseDto data = null;

        String telNumber = dto.getTelNumber();
        String departmentCode = dto.getDepartment();

        // 데이터베이스 접속 오류
        try {
            // 동일한 전화번호가 았을 때
            boolean hasTelNumber = employeeRepository.existsByTelNumber(telNumber);
            if (hasTelNumber) return ResponseDto.setFail(ResponseMessage.EXIST_TELEPHONE_NUMBER);

            // 부서코드를 입력했을 때
            if (departmentCode != null) {
                boolean hasDepartment = departmentRepository.existsById(departmentCode);

                // 존재하지않는 부서코드일 경우
                if (!hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);
            }
            //
            EmployeeEntity employeeEntity = new EmployeeEntity(dto);
            employeeRepository.save(employeeEntity);

            data = new PostHumanResourceResponseDto(employeeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    //
    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(int employeeNumber) {

        GetHumanResourceResponseDto data = null;

        try {
            // = 데이터베이스에 2번 접근
            // boolean hasEmployee = employeeRepository.existsById(employeeNumber);
            // if (!hasEmployee) return ResponseDto.setFail(ResponseMessage.FAIL);
            // employeeNumber가 PK라서 findById().get() 사용가능
            // 존재하지않는 값이라면 해당 메서드 실행 결과가 null이 됨
            // EmployeeEntity employeeEntity = employeeRepository.findById(employeeNumber).get();

            // = 데이터베이스에 1번 접근
            // 위와는 다르게 같은 타입이기 때문에 .get()을 사용하지 않아도 사용가능
            EmployeeEntity employeeEntity = employeeRepository.findByEmployeeNumber(employeeNumber);
            if (employeeEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            data = new GetHumanResourceResponseDto(employeeEntity);
        
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

}
