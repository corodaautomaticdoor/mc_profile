package com.coroda.dao;

import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;




public interface PersonDao {

    Completable save(PersonRequest model);
    Observable<PersonResponse> findAll();
    Single<PersonResponse> getById(Long idPerson);
    Completable delete(Long idPerson);
    Completable update(PersonRequest model);

    Observable<PersonResponse> searchNumberDocumentPerfil(Long numberDocument);
}
