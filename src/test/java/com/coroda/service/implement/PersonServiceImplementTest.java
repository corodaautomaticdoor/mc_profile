package com.coroda.service.implement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.coroda.dao.implement.PersonDaoImplement;
import com.coroda.dto.request.PersonRequest;
import com.coroda.dto.response.PersonResponse;
import com.coroda.util.TestUtil;
import com.google.gson.Gson;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import lombok.var;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PersonServiceImplementTest {

    @InjectMocks
    private PersonServiceImplement personService;

    @Mock
    private PersonDaoImplement personDao;

    private static final Gson GSON = new Gson();
    private static final Long ID_PERSON = Long.valueOf(1);
    private static final Long DOCUMENT_NUMBER = Long.valueOf(71723707);

    @Before
    public void setup(){
        initMocks(this);
    }

    @Test
    @DisplayName("Cuando se guardan correctamente los datos del Perfil")
    public void returnSuccessWhenSaveOk(){
        PersonRequest personRequest = GSON.fromJson(TestUtil.readJsonFileToString("mock/person_request.json"),
                PersonRequest.class);
        when(personService.save(any())).thenReturn(Completable.complete());
        TestObserver<Void> testObserver = personService.save(personRequest).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();

    }

    @Test
    @DisplayName("Obtiene  los datos de un Perfil en especifico corde al id_person")
    public void returnPerfilResponseWhenIdPersonOk(){
        PersonResponse personResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/person_response.json"),
                PersonResponse.class);
        when(personDao.getById(ID_PERSON)).thenReturn(Single.just(personResponse));
        TestObserver<PersonResponse> testObserver = personService.getById(ID_PERSON).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();

        var actual = testObserver.values().get(0);
        assertThat(actual.getIdPerson()).isEqualTo(ID_PERSON);

    }

    @Test
    @DisplayName("Obtiene  los datos de un Perfil en especifico acorde al número de documento")
    public void returnPerfilResponseWhenDocumentNumberOk(){
        PersonResponse personResponse = GSON.fromJson(TestUtil.readJsonFileToString("mock/person_request.json"),
                PersonResponse.class);
        when(personDao.searchNumberDocumentPerfil(DOCUMENT_NUMBER)).thenReturn(Maybe.just(personResponse));
        TestObserver<PersonResponse> testObserver = personService.getByNumberDocument(DOCUMENT_NUMBER).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
        var actual = testObserver.values().get(0);
        assertThat(actual.getNumberDocument()).isEqualTo(DOCUMENT_NUMBER);

    }

}