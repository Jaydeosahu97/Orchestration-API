package com.jay.orchestration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class DummyJsonResponse {
    private List<UserDTO> users;
}
