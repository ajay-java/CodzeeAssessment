package com.nt.entity.offers;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name="MUTLTIDB_OFFERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Offers {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "oid_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer oid;
	
	@Column(length = 30)
	@NonNull
	private String oname;

	@NonNull
	@DecimalMin(value = "0.00", message = "Discount cannot be negative")
	@DecimalMax(value = "100.00", message = "Discount cannot exceed 100")
	@Digits(integer = 3, fraction = 2,
			message = "Discount must have at most 2 decimal places")
	@Column(precision = 5, scale = 2)
	private BigDecimal discount;
	@NonNull
	private  LocalDate expiryDate;
	

}
