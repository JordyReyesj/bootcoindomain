package com.nttdata.bootcoindomain.repository;

import com.nttdata.bootcoindomain.model.ChangeRate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * ChangeRateRepository.
 */
public interface ChangeRateRepository extends ReactiveMongoRepository<ChangeRate, String> {
  /**
   * find by name.
   */
  Mono<ChangeRate> findByName(String name);
}
