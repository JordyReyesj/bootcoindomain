package com.nttdata.bootcoindomain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

/**
 * ClientBootcoin.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "client-bootcoin")
public class ClientBootcoin {
  @Id
  private String id;
  @NotEmpty
  private String dni;
  @NotEmpty
  private String phone;
  @NotEmpty
  private String email;

}
