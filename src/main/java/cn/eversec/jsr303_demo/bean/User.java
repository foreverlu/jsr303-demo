package cn.eversec.jsr303_demo.bean;

import cn.eversec.jsr303_demo.config.Phone;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
    @NotNull(message = "用户名不能为空")
    @NotEmpty(message = "用户名不能为空")
    private String name;

    @NotNull(message = "密码不能为空")
    @Size(min = 4,max=4,message = "密码长度必须大于8,小于33")
    private String pwd;

    @NotNull(message = "电话不能为空")
    @NotEmpty(message = "电话不能为空")
    @Phone(message = "电话格式不正确")
    private String phone;
}
