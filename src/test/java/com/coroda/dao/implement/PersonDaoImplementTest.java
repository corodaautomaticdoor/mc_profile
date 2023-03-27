package com.coroda.dao.implement;

import com.coroda.dto.response.PersonResponse;
import com.coroda.entity.Person;
import com.coroda.exception.ResourceNotFoundException;
import com.coroda.repository.PersonRepository;
import com.coroda.util.TestUtil;
import com.google.gson.Gson;
import io.reactivex.observers.TestObserver;
import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
class PersonDaoImplementTest {

    @InjectMocks
    private PersonDaoImplement personDaoImplement;

    @Mock
    private PersonRepository repository;

    private static final Gson GSON = new Gson();
    private static final Long ID_PERSON = Long.valueOf(1);
    private static final Long DOCUMENT_NUMBER = Long.valueOf(71723707);

    @BeforeEach
    void setUp() {
        initMocks(this);
        this.personDaoImplement = new PersonDaoImplement(repository);
    }

    @Test
    @DisplayName("Obtiene  los datos de un Perfil en especifico corde al id_person")
    public void returnPerfilResponseWhenIdPersonOk(){
        Person person = GSON.fromJson(TestUtil.readJsonFileToString("mock/person_response.json"),
                Person.class);
        when(repository.findById(ID_PERSON)).thenReturn(Optional.ofNullable(person));
        TestObserver<PersonResponse> testObserver = personDaoImplement.getById(ID_PERSON).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();

        var actual = testObserver.values().get(0);
        assertThat(actual.getIdPerson()).isEqualTo(ID_PERSON);
    }

    @Test
    @DisplayName("Obtiene  los datos de un Perfil en especifico acorde al número de documento")
    public void returnPerfilResponseWhenDocumentNumberOk(){
        Person person = GSON.fromJson(TestUtil.readJsonFileToString("mock/person_response.json"),
                Person.class);
        when(repository.searchNumberDocument(DOCUMENT_NUMBER)).thenReturn(Arrays.asList(person));
        TestObserver<PersonResponse> testObserver = personDaoImplement.searchNumberDocumentPerfil(DOCUMENT_NUMBER).test();
        testObserver.awaitTerminalEvent();
        testObserver.assertComplete();
        testObserver.assertNoErrors();
        var actual = testObserver.values().get(0);
        assertThat(actual.getNumberDocument()).isEqualTo(DOCUMENT_NUMBER);
    }



}