package com.coroda.dao;

import com.coroda.dto.request.BodyPersonRequest;
import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface PersonDao {

    Completable save(PersonRequest model);
    Observable<PersonResponse> findAll();
    Single<PersonResponse> getById(Long idPerson);
    Completable delete(Long idPerson);
    Completable update(PersonRequest model);

    Maybe<PersonResponse> searchNumberDocumentPerfil(Long numberDocument);
    Observable<PersonResponse> searchDni(BodyPersonRequest request);

    Maybe<PersonResponse> searchEmail(String email);
}
