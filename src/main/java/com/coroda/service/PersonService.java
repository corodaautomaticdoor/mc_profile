package com.coroda.service;

import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface PersonService {
    Completable save(PersonRequest model);
    Observable<PersonResponse> findAll();
    Single<PersonResponse> getById(Long idPerson);
    Completable delete(Long idPerson);
    Completable update(PersonRequest model);
}
