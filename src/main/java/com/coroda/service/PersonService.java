package com.coroda.service;

import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Map;

public interface PersonService {
    Completable save(PersonRequest model);
//    Observable<PersonResponse> findAll();
    Single<PersonResponse> getById(Long idPerson);
    Observable<PersonResponse> getByNumberDocument(Long numberDocument);
    Completable delete(Long idPerson);
    Completable update(PersonRequest model);

    Observable<PersonResponse> getData(Map<Long, String> params);
}
