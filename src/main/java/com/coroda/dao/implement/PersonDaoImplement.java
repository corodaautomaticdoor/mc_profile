package com.coroda.dao.implement;

import com.coroda.dao.PersonDao;
import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import com.coroda.entity.Person;
import com.coroda.repository.PersonRepository;
import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.ws.rs.BadRequestException;

@Slf4j
@Repository
@AllArgsConstructor
public class PersonDaoImplement implements PersonDao {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Completable save(PersonRequest model) {
        return Single.fromCallable(()-> toSave(model))
                .map(personRepository::save)
                .toCompletable();
    }
    //Este método privado ayuda al método públic SAVE
    private Person toSave(PersonRequest model){

        log.info("Se da el seteo de datos del metodo save");
        Person person= new Person();
        person.setIdPerson(model.getIdPerson());
        person.setTypeDocument(model.getTypeDocument());
        person.setTypePerson(model.getTypePerson());
        person.setNumberDocument(model.getNumberDocument());
        person.setName(model.getName());
        person.setLastName1(model.getLastName1());
        person.setLastName2(model.getLastName2());
        person.setSocialReason(model.getSocialReason());
        person.setAddress(model.getAddress());
        person.setEmail(model.getEmail());
        person.setPhone(model.getPhone());
        return person;
    }

    @Override
    public Observable<PersonResponse> findAll() {
        log.info("Se da el seteo de todos los datos registrados");
        return Observable.fromIterable(personRepository.findAll())
                .map(person -> getPersonResponse(person))
                .subscribeOn(Schedulers.io());
    }

    //Este método privado ayuda al método públic FINDALL y tambien a GETBYID
    private PersonResponse getPersonResponse(Person model) {

        PersonResponse personResponse= new PersonResponse();
        personResponse.setIdPerson(model.getIdPerson());
        personResponse.setTypeDocument(model.getTypeDocument());
        personResponse.setTypePerson(model.getTypePerson());
        personResponse.setNumberDocument(model.getNumberDocument());
        personResponse.setName(model.getName());
        personResponse.setLastName1(model.getLastName1());
        personResponse.setLastName2(model.getLastName2());
        personResponse.setSocialReason(model.getSocialReason());
        personResponse.setAddress(model.getAddress());
        personResponse.setEmail(model.getEmail());
        personResponse.setPhone(model.getPhone());

        return personResponse;
    }

    @Override
    public Single<PersonResponse> getById(Long idPerson) {
        log.info("Seteo de datos por Id");
        return maybeAt(idPerson)
                .map(person -> getPersonResponse(person))
                .toSingle();
    }

    @Override
    public Completable delete(Long idPerson) {
        return maybeAt(idPerson).flatMapCompletable(person -> {
            personRepository.deleteById(idPerson);
            return CompletableObserver::onComplete;
        });
    }

    @Override
    public Completable update(PersonRequest model) {
        return maybeAt(model.getIdPerson()).flatMapCompletable(person -> {
            return save(model);
        });
    }

    @Override
    public Observable<PersonResponse> searchNumberDocumentPerfil(Long numberDocument) {
        log.info("Extrayendo reistros del perfil  acorde al número de documento");
        return Observable.fromIterable(personRepository.searchNumberDocument(numberDocument))
                .filter(obj -> obj.getNumberDocument().equals(numberDocument))
                .map(person -> getPersonResponse(person))
                .subscribeOn(Schedulers.io());
    }

    //Este método privado ayuda al método públic GETBYID / DELETE / UPDATE
    private Maybe<Person> maybeAt(Long idPerson){
        log.info("buscando por id y obteniendo los campos");
        return Maybe.just(
                personRepository.findById(idPerson)
                        .<BadRequestException>orElseThrow(BadRequestException::new))
                .switchIfEmpty(Maybe.empty());
    }
}

