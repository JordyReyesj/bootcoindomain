package com.nttdata.bootcoindomain.controller;

import com.nttdata.bootcoindomain.exception.ErrorSummary;
import com.nttdata.bootcoindomain.model.ChangeRate;
import com.nttdata.bootcoindomain.service.ChangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * ChangeRate Controller.
 */
@RestController
@RequestMapping("/api/boot-coin/change-rate")
@Slf4j
public class ChangeRateController {

  private final ChangeRateService changeRateService;

  public ChangeRateController(ChangeRateService changeRateService) {
    this.changeRateService = changeRateService;
  }

  /**
   * FindAll ChangeRate.
   */
  @GetMapping
  public Mono<ResponseEntity<Flux<ChangeRate>>> findAll() {
    log.info("ChangeRateController findAll ->");
    return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
            .body(changeRateService.findAll()));
  }

  /**
   * Find ChangeRate.
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<ChangeRate>> findById(@PathVariable String id) {
    log.info("ChangeRateController findById ->");
    return changeRateService.findById(id)
            .map(ce -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ce))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   * create ChangeRate.
   */
  @PostMapping
  public Mono<ResponseEntity<Map<String, Object>>> create(
          @Valid @RequestBody Mono<ChangeRate> changeRateMono) {
    log.info("ChangeRateController create ->");
    Map<String, Object> result = new HashMap<>();
    return changeRateMono.flatMap(c -> changeRateService.create(c)
                    .map(p -> ResponseEntity.created(URI.create("/api/boot-coin/change-rate/".concat(p.getId())))
                            .contentType(MediaType.APPLICATION_JSON).body(result)))
            .onErrorResume(ErrorSummary::errorSummaryException);
  }
  /**
   * update ChangeRate.
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Map<String, Object>>> update(
          @Valid @RequestBody Mono<ChangeRate> changeRateMono, @PathVariable String id) {
    log.info("ChangeRateController create ->");
    Map<String, Object> result = new HashMap<>();
    return changeRateMono.flatMap(c -> changeRateService.update(c, id)
                    .flatMap(p -> {
                      result.put("data", p);
                      return Mono.just(ResponseEntity.ok().body(result));
                    }))
            .onErrorResume(ErrorSummary::errorSummaryException);
  }

  /**
   * Delete ChangeRate.
   */
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    log.info("ChangeRateController delete ->");
    return changeRateService.findById(id)
            .flatMap(e -> changeRateService.delete(e)
                    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
