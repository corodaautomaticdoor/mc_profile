package com.coroda.controller;

import com.coroda.dto.request.BodyPersonRequest;
import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import com.coroda.service.PersonService;
import com.coroda.util.Constants;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(Constants.MAIN_PATH)
@Api(tags = "Microservicio Perfil", description = "Esta API se encarga de la gestion de los Perfiles")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ApiOperation(value = Constants.SAVE_VALUE, notes = Constants.SAVE_NOTE)
    public Completable save(@RequestBody PersonRequest model){
        return personService.save(model);
    }

    @GetMapping
    @ApiOperation(value = Constants.GETDATA_VALUE, notes = Constants.GETDATA_NOTE)
    public  Observable<PersonResponse> getData(@RequestParam Map<Long, String> params){
        return personService.getData(params);
    }

    @GetMapping(Constants.ID)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public  Single<PersonResponse> getById( @PathVariable("idPerson") Long idPerson){
        return  personService.getById(idPerson);
    }

    @GetMapping(Constants.NUMBER_DOCUMENT)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public  Maybe<PersonResponse> getByNumberDocument( @PathVariable("numberDocument") Long numberDocument){
        return  personService.getByNumberDocument(numberDocument);
    }

    @DeleteMapping(Constants.ID)
    @ApiOperation(value = Constants.DELETE_ID_VALUE, notes = Constants.DELETE_ID_NOTE)
    public  Completable delete(@PathVariable("idPerson") Long idPerson){
        return personService.delete(idPerson);
    }

    @PutMapping(Constants.ID)
    @ApiOperation(value = Constants.UPDATE_ID_VALUE, notes = Constants.UPDATE_ID_NOTE)
    public Completable update(@RequestBody PersonRequest model){
        return personService.update(model);
    }

    @GetMapping(Constants.BODY_LIST_DNI)
    @ApiOperation(value = Constants.GET_ID_VALUE, notes = Constants.GET_ID_NOTE)
    public  Observable<PersonResponse> SearchBodyListDni( @RequestBody List<BodyPersonRequest> requestList){
        return  personService.searchListDni(requestList);
    }

    @GetMapping(Constants.EMAIL)
    @ApiOperation(value = Constants.GETEMAIL_VALUE, notes = Constants.GETEMAIL_NOTE)
    public Maybe<PersonResponse> searchEmail(@PathVariable("email") String email){
        return  personService.searchEmail(email);
    }

}
