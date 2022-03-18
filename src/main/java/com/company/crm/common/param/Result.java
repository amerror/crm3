package com.company.crm.common.param;

import lombok.Data;

/**
 * @author zytwl
 */
@Data
public class Result {
    private String code;
    private Boolean flag;
    private String msg;
    private Object object;

    public Result(String code, Boolean flag, String msg, Object object) {
        this.code = code;
        this.flag = flag;
        this.msg = msg;
        this.object = object;
    }

    public static Result success(Object object){
        return new Result("200",true,"",object);
    }

    public static Result failed(String code, String msg){
        return new Result(code,false,msg,null);
    }
}
