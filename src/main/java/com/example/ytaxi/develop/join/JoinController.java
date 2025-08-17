package com.example.ytaxi.develop.join;

import com.example.ytaxi.develop.join.dto.JoinDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/join")
@Slf4j
public class JoinController {

    @Autowired
    private JoinServiceImpl joinService;

    @RequestMapping(value = "/userJoin", method={RequestMethod.POST})
    public Map<String, Object> userJoin(@RequestBody JoinDTO joinDTO) throws Exception {
        Map<String, Object> userJoinMap = new HashMap<>();

        try {
            if ("U".equals(joinDTO.getJoinType())) {
                String createdId = "홍길동";
                joinDTO.setCreated_id(createdId);
                joinDTO.setUpdated_id(createdId);

                System.out.println("joinDTO : " + joinDTO);
            }

            int result = joinService.joinUser(joinDTO);

            if (result > 0) {
                userJoinMap.put("STATUS", "success");
                userJoinMap.put("MESSAGE", "회원가입 성공");
            } else {
                userJoinMap.put("STATUS", "fail");
            }
            return userJoinMap;
        } catch (Exception e) {
            log.error("회원가입 중 예외 발생", e);
            userJoinMap.put("STATUS", "error");
            userJoinMap.put("MESSAGE", "회원가입 실패: " + e.getMessage());
            return userJoinMap;
        }
    }
}
