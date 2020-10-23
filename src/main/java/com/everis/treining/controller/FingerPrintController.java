package com.everis.treining.controller;

import com.everis.treining.entity.FingerPrint;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/core/fingerprints")
public class FingerPrintController {

  @Value("${entityName}")
  String entityName;
  @Value("${success}")
  boolean success;

  /**
   * Method Comment.
   * 
   * @throws Exception
   * 
   * 
   */
  @PostMapping("/validate")
  public Single<FingerPrint> responseReniec(@RequestBody String document) {
    try {
      return Single.just(new FingerPrint(entityName, success));
    } catch (Exception e) {
      return Single.just(new FingerPrint());
    }
  }

}
