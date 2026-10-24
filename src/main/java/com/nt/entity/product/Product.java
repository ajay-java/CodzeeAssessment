package com.nt.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="MUTLTIDB_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "pid_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@Column(length = 30)
	@NonNull
	private String pname;

	@NonNull
	@Column(precision = 12, scale = 2)
	private BigDecimal price;

	@NonNull
	private  Integer qty;

}
