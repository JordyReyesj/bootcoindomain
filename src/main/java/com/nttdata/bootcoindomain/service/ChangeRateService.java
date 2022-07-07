package com.nttdata.bootcoindomain.service;

import com.nttdata.bootcoindomain.model.ChangeRate;
import com.nttdata.bootcoindomain.repository.ChangeRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ChangeRateService.
 */
@Service
@Slf4j
public class ChangeRateService {
  @Autowired
  private ChangeRateRepository changeRateRepository;

  /**
   * findAll ChangeRate.
   */
  public Flux<ChangeRate> findAll() {
    log.info("TariffService findAll-> ");
    return changeRateRepository.findAll();
  }

  /**
   * findById ChangeRate.
   */
  public Mono<ChangeRate> findById(String id) {
    return changeRateRepository.findById(id);
  }

  /**
   * create Tariff.
   */
  public Mono<ChangeRate> create(ChangeRate changeRate) {
    return changeRateRepository.save(changeRate);
  }

  /**
   * update ChangeRate.
   */
  public Mono<ChangeRate> update(ChangeRate changeRate, String id) {
    log.info("ChangeRateService update -> ");
    return changeRateRepository.findById(id)
            .switchIfEmpty(Mono.error(new RuntimeException("Change Rate not found")))
            .flatMap(p -> changeRateRepository.findByName(changeRate.getName())
                    .switchIfEmpty(Mono.defer(() -> changeRateRepository.save(parseIdToChangeRate(changeRate, id))))
                    .flatMap(obj -> {
                      if (obj != null) {
                        if (obj.getId().equals(id)) {
                          return changeRateRepository.save(parseIdToChangeRate(changeRate, id));
                        } else {
                          return Mono.error(new RuntimeException("Change Rate exist other side!"));
                        }
                      } else {
                        return changeRateRepository.save(parseIdToChangeRate(changeRate, id));
                      }
                    }));
  }
  private ChangeRate parseIdToChangeRate(ChangeRate changeRate, String id) {
    changeRate.setId(id);
    return changeRate;
  }

  /**
   * delete ChangeRate.
   */
  public Mono<Void> delete(ChangeRate changeRate) {
    return changeRateRepository.delete(changeRate);
  }
}
