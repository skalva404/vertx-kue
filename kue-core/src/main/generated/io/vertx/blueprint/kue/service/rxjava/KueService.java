/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.blueprint.kue.service.rxjava;

import java.util.Map;
import rx.Observable;
import io.vertx.blueprint.kue.queue.Job;
import io.vertx.rxjava.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Vert.x Blueprint - Job Queue
 * Kue Service Interface
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.blueprint.kue.service.KueService original} non RX-ified interface using Vert.x codegen.
 */

public class KueService {

  final io.vertx.blueprint.kue.service.KueService delegate;

  public KueService(io.vertx.blueprint.kue.service.KueService delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public static KueService create(Vertx vertx, JsonObject config) {
    KueService ret = KueService.newInstance(io.vertx.blueprint.kue.service.KueService.create((io.vertx.core.Vertx) vertx.getDelegate(), config));
    return ret;
  }

  public static KueService createProxy(Vertx vertx, String address) {
    KueService ret = KueService.newInstance(io.vertx.blueprint.kue.service.KueService.createProxy((io.vertx.core.Vertx) vertx.getDelegate(), address));
    return ret;
  }

  /**
   * Process a job in asynchronous way
   * @param type job type
   * @param handler job process handler
   * @return 
   */
  public KueService process(String type, Handler<AsyncResult<Job>> handler) { 
    delegate.process(type, handler);
    return this;
  }

  /**
   * Process a job in asynchronous way
   * @param type job type
   * @return 
   */
  public Observable<Job> processObservable(String type) { 
    io.vertx.rx.java.ObservableFuture<Job> handler = io.vertx.rx.java.RxHelper.observableFuture();
    process(type, handler.toHandler());
    return handler;
  }

  /**
   * Process a job in synchronous and blocking way
   * @param type job type
   * @param handler job process handler
   * @return 
   */
  public KueService processBlocking(String type, Handler<AsyncResult<Job>> handler) { 
    delegate.processBlocking(type, handler);
    return this;
  }

  /**
   * Process a job in synchronous and blocking way
   * @param type job type
   * @return 
   */
  public Observable<Job> processBlockingObservable(String type) { 
    io.vertx.rx.java.ObservableFuture<Job> handler = io.vertx.rx.java.RxHelper.observableFuture();
    processBlocking(type, handler.toHandler());
    return handler;
  }


  public static KueService newInstance(io.vertx.blueprint.kue.service.KueService arg) {
    return arg != null ? new KueService(arg) : null;
  }
}
