package org.gttech.interview.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Table(name = "t_city")
@Data
public class TCity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 城市名称
     */
    private String name;

    private static final long serialVersionUID = 1L;
}