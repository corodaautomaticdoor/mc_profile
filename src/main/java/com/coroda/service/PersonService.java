package com.coroda.service;

import com.coroda.dto.request.BodyPersonRequest;
import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.List;
import java.util.Map;

public interface PersonService {
    Completable save(PersonRequest model);
    Single<PersonResponse> getById(Long idPerson);
    Maybe<PersonResponse> getByNumberDocument(Long numberDocument);
    Completable delete(Long idPerson);
    Completable update(PersonRequest model);

    Observable<PersonResponse> getData(Map<Long, String> params);
    Observable<PersonResponse> searchListDni(List<BodyPersonRequest> requestList);

    Maybe<PersonResponse> searchEmail(String email);

}
