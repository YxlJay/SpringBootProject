package com.yxl.application.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxl
 * @since 2023-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    private String proname;

    private String prosn;

    private BigDecimal proprice;

    private Integer pronum;

    private String proimg;

    private String desc;

    private String profullname;

    private String unit;

    private LocalDateTime createdate;

    private Integer status;


}
