package com.bubu.pojo;

/**
 * @author qjl
 * @create 2023-01-09 17:18
 */
public class Yier {
    // id 主键
    private Integer id;
    // 品牌名称
    private String friendName;
    // 企业名称
    private String schoolName;
    // 排序字段
    private Integer age;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;

    @Override
    public String toString() {
        return "Yier{" +
                "id=" + id +
                ", friendName='" + friendName + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    //逻辑视图
    public String getStatusStr(){
        if (status == null){
            return "未知";
        }
        return status == 0 ? "男":"女";
    }
}
