package com.example.ytaxi.develop.join;

import com.example.ytaxi.develop.join.dto.JoinDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JoinService {
    public int joinUser(JoinDTO joinDTO) throws Exception;
}
