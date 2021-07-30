package com.coroda.service.implement;

import com.coroda.dao.PersonDao;
import com.coroda.dto.request.BodyPersonRequest;
import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import com.coroda.service.PersonService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PersonServiceImplement implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Completable save(PersonRequest model) {
        return personDao.save(model);
    }

    @Override
    public Single<PersonResponse> getById(Long idPerson) {
        return personDao.getById(idPerson);
    }

    @Override
    public Observable<PersonResponse> getByNumberDocument(Long numberDocument) {
        return personDao.searchNumberDocumentPerfil(numberDocument);
    }

    @Override
    public Completable delete(Long idPerson) {
        return personDao.delete(idPerson);
    }

    @Override
    public Completable update(PersonRequest model) {
        return personDao.update(model);
    }

    @Override
    public Observable<PersonResponse> getData(Map<Long, String> params) {
        log.info("Busqueda Dinamica");
        Observable<PersonResponse> personResponseObservable = null;
        Long numberDocument;

        if (!params.isEmpty()) {
            if(params.get("numberDocument") != null ){
                log.info("Buscando por numero de documento");
                numberDocument = Long.valueOf(params.get("numberDocument"));
                personResponseObservable = personDao.searchNumberDocumentPerfil(numberDocument);
            }
        }else {
            log.info("Buscando todos los registros");
            personResponseObservable=personDao.findAll();
        }

        return personResponseObservable;
    }

    @Override
    public Observable<PersonResponse> searchListDni(List<BodyPersonRequest> requestList) {
        return Observable.fromIterable(requestList)
                .flatMap(person->personDao.searchDni(person))
                .subscribeOn(Schedulers.io());
    }

}
