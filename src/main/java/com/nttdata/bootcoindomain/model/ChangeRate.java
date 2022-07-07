package com.nttdata.bootcoindomain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * ChangeRate.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "change-rate")
public class ChangeRate {
  @Id
  private String id;
  @NotNull
  private BigDecimal purchaseRate;
  @NotNull
  private BigDecimal sellingRate;
}
