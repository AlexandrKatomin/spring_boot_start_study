package ru.homecredit.springstart;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.homecredit.springstart.dto.PersonDto;
import ru.homecredit.springstart.entity.Person;
import ru.homecredit.springstart.repository.PersonRepository;
import ru.homecredit.springstart.service.PersonService;
import ru.homecredit.springstart.service.PersonServiceImpl;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    public static final long PERSON_ID = 123L;
    public static final Integer PERSON_AGE = 23;
    public static final String PASPORT_NUMBER = "1234 567890";
    public static final String PHONE_NUMBER = "8-800-2000-600";
    public static final String PERSON_NAME = "test name";
    Person person;


    @InjectMocks
    private PersonService service = new PersonServiceImpl();
    @Mock
    private PersonService service1;
    @Mock
    private PersonRepository repository;
    @Mock
    private HashMap<Long, Person> persons;

    @BeforeClass
    public static void beforeClass() {
    }

    @Before
    public void before() throws Exception {

        person = new Person();
        person.setId(PERSON_ID);
        person.setAge(PERSON_AGE);
        person.setName(PERSON_NAME);
        person.setPhone(PHONE_NUMBER);
        person.setPassport(PASPORT_NUMBER);
        person.setManager(person);

        persons.put(1234L, person);
    }

    @Test
    public void tetGet() {
        when(repository.getOne(any()))
                .thenReturn(person)
                .thenReturn(person);

        PersonDto personDto = service.get(PERSON_ID);
        personDto = service.get(1234L);
        assertNotNull(personDto.getName());
        assertNotNull(personDto.getAge());
        assertThat(personDto.getAge(), allOf(greaterThanOrEqualTo(18), lessThanOrEqualTo(99)));
        assertNotNull(personDto.getPassport());
        assertEquals(personDto.getPassport(), PASPORT_NUMBER);


        verify(repository, times(1)).getOne(any()); //проверяем, что вызов метода был единожды
    }


    @Test(expected = NoSuchElementException.class)
    public void personUpdateThrowException() throws Exception {

        PersonDto dto = new PersonDto();
        when(service1.update(any()))
                .thenThrow(new NoSuchElementException())
                .thenReturn(dto);
//        doThrow(new NoSuchElementException()).when(service1).update(any());
        PersonDto resultDto = service1.update(dto);
    }

    @Test
    public void personUpdateTest() throws Exception {

        PersonDto dto = new PersonDto();
        when(service1.update(any())).thenReturn(dto);
        service1.update(dto);

    }


}
