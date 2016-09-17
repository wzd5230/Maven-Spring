package cn.wzd.ssm.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.wzd.ssm.controller.validation.SingleItemsEditValidation;

public class Items {
    private Integer id;

    @Size(min=1,max=30,message="{items.name.validation.size.error}",groups={SingleItemsEditValidation.class})
    private String name;

    private Float price;

    private String pic;

    @NotNull(message="{items.createtime.validation.notNull}",groups={SingleItemsEditValidation.class})
    private Date createtime;

    @NotBlank(message="{items.detail.validation.notBlank}",groups={SingleItemsEditValidation.class})
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}