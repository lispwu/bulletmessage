package com.code.will.bulletmessage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

    private String code;

    private String message;

    private Object data;

    public static enum ResultDescription {
        /**
         * 操作成功描述
         */
        SUCCESS,
        /**
         * 操作失败描述(在无异常时使用)
         */
        FAIL,
    }
}

