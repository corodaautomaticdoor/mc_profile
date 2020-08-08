package com.coroda.service.implement;

import com.coroda.dao.PersonDao;
import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import com.coroda.service.PersonService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplement implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Completable save(PersonRequest model) {
        return personDao.save(model);
    }

    @Override
    public Observable<PersonResponse> findAll() {
        return personDao.findAll();
    }

    @Override
    public Single<PersonResponse> getById(Long idPerson) {
        return personDao.getById(idPerson);
    }

    @Override
    public Completable delete(Long idPerson) {
        return personDao.delete(idPerson);
    }

    @Override
    public Completable update(PersonRequest model) {
        return personDao.update(model);
    }
}
